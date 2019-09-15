package com.cloud.zhpt.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.cloud.zhpt.Const.SessionKeyConst;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.Service.UserService;
import com.cloud.zhpt.Utils.IPUtils;
import com.cloud.zhpt.entity.User;
import com.cloud.zhpt.warper.WebSocketServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName LoginController
 * @Description
 * @Author SW
 * @Date 2019/8/15 15:41
 **/
@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private  String validateCode;
    /**
     * 保存登录账号的COOKIE名称
     */
    private final String LOGIN_NAME_COOKIE = "LAST_LOGIN_NAME";

    /**
     * COOKIE失效时间
     */
    private final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365;


    private final int SESSION_MAX_AGE = 60 * 5;

    @Autowired
    UserService userService;

    @Autowired
    WebSocketServer webSocketServer;

    @PostMapping("/login")
    public HttpResult Login(String userName, String password,String captcha, boolean rememberMe, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!StringUtils.hasText(captcha)){
          return new HttpResult(HttpResult.FAILED,"验证码不能为空……");
        };
        HttpSession session = request.getSession();
        if(!captcha.equals(validateCode)){
            return new HttpResult(HttpResult.FAILED,"验证码错误……");
        }
        String passwordMD5 = password;
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passwordMD5);
        Subject subject = SecurityUtils.getSubject();

        // 执行验证
        subject.login(token);
        // 用户验证成功
        // 将用户信息保存到session
        User user = userService.getUserByLoginName(userName);
        // 保存账号至cookie
        Cookie cookie = new Cookie(LOGIN_NAME_COOKIE, userName);
        // 保存一年
        cookie.setMaxAge(COOKIE_MAX_AGE);
        cookie.setPath("/");
        response.addCookie(cookie);

        session.setAttribute(SessionKeyConst.USER_SESSION_CONATEXT, user);
        // 更新用户登录信息
        String loginIp = IPUtils.getIpAddr(request);
        userService.updateLoginInfo(user.getId(), new Date(), loginIp);
        return new HttpResult(HttpResult.SUCCESS, user);

    }


    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public HttpResult notLogin() {
        return new HttpResult(HttpResult.FAILED, "您尚未登陆…");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public HttpResult notRole() {
        return new HttpResult(HttpResult.FAILED, "您无权限…");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public HttpResult logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return new HttpResult(HttpResult.SUCCESS, "成功退出…");
    }


    @GetMapping("/getImgCode")
    public synchronized void getImgCode(HttpServletRequest req, HttpServletResponse response) {
        logger.info("【系统登陆】开始生成图像验证码……");
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(80, 26, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        String code = captcha.getCode();
        logger.info("【系统登陆】当前验证码："+ code);
        validateCode = code;
        try {
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
