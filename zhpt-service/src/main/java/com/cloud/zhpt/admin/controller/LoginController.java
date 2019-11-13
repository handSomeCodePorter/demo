package com.cloud.zhpt.admin.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.cloud.zhpt.Const.EncryptKeyConst;
import com.cloud.zhpt.Const.SessionKeyConst;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.Service.UserService;
import com.cloud.zhpt.Utils.IPUtils;
import com.cloud.zhpt.admin.dto.UserDto;
import com.cloud.zhpt.admin.entity.User;
import com.cloud.zhpt.exception.CustomRunTimeException;
import com.cloud.zhpt.warper.WebSocketServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private String validateCode;
    /**
     * 保存登录账号的COOKIE名称
     */
    private final String LOGIN_NAME_COOKIE = "LAST_LOGIN_NAME";

    /**
     * COOKIE失效时间
     */
    private final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365;


    private final int SESSION_MAX_AGE = 60 * 5;


    /**
     * 16进制 的 加密key
     */
    private long i1 = Long.valueOf(EncryptKeyConst.USER_ENCRYPT_KEY, 16);

    private byte[] key = String.format("%016x", i1).getBytes();

    /**
     * 构建aes
     */
    private AES aes = SecureUtil.aes(key);

    @Autowired
    UserService userService;

    @Autowired
    WebSocketServer webSocketServer;

    @Value("${login.captcha}")
    private boolean logincaptcha;


    @PostMapping("/login")
    public HttpResult Login(HttpServletRequest request, HttpServletResponse response, String userName, String password, String captcha, boolean rememberMe) {
        String msg = "";
        if (logincaptcha) {
            if (!StringUtils.hasText(captcha)) {
                return new HttpResult(HttpResult.FAILED, "验证码不能为空……");
            }
            ;
            if (!captcha.equals(validateCode)) {
                return new HttpResult(HttpResult.FAILED, "验证码错误……");
            }
        }
        String passwordMD5 = password;
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passwordMD5);
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            // 执行验证
            subject.login(token);
            // 将用户信息保存到session
            User user = userService.getUserByLoginName(userName);
            session.setAttribute(SessionKeyConst.USER_SESSION_CONATEXT, JSON.toJSONString(user));
            // 更新用户登录信息
            String loginIp = IPUtils.getIpAddr(request);
            userService.updateLoginInfo(user.getId(), new Date(), loginIp);
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(user, dto);
            if (rememberMe) {
                //加密
                byte[] encrypt = aes.encrypt(JSON.toJSONString(user));
                dto.setEncryptUser(Base64Utils.encodeToString(encrypt));
            }
            dto.setSid(session.getId().toString());
            return new HttpResult(HttpResult.SUCCESS, dto, "登录成功");
        } catch (IncorrectCredentialsException e) {
            msg = "用户名或密码错误";

        } catch (ExcessiveAttemptsException e) {
            msg = "【登录失败次数过多】";
            return new HttpResult(HttpResult.FAILED, msg);
        } catch (LockedAccountException e) {
            msg = "【帐号已被锁定】 The account for username " + token.getPrincipal() + " was locked.";
            return new HttpResult(HttpResult.FAILED, msg);
        } catch (DisabledAccountException e) {
            msg = "【帐号已被禁用】 The account for username " + token.getPrincipal() + " was disabled.";
            return new HttpResult(HttpResult.FAILED, msg);
        } catch (ExpiredCredentialsException e) {
            msg = "【帐号已被禁用】  the account for username " + token.getPrincipal() + "  was expired.";
            return new HttpResult(HttpResult.FAILED, msg);
        } catch (UnknownAccountException e) {
            msg = "【账户不存在】 There is no user with username of " + token.getPrincipal();
            return new HttpResult(HttpResult.FAILED, msg);
        } catch (UnauthorizedException e) {
            msg = e.getMessage();
            return new HttpResult(HttpResult.FAILED, msg);
        }
        return new HttpResult(HttpResult.FAILED, msg);

    }

    @PostMapping("/loginWithRememberMe")
    public HttpResult loginWithRememberMe(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String encryptUser = request.getParameter("encryptUser");
        if (!StringUtils.hasText(encryptUser)) {
            return new HttpResult(HttpResult.FAILED, "验证失败");
        }

        byte[] decrypt = aes.decrypt(Base64Utils.decodeFromString(encryptUser));
        User user = JSON.parseObject(decrypt, User.class);
        if (user == null) {
            return new HttpResult(HttpResult.FAILED, "验证失败");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        // 执行验证
        subject.login(token);
        session.setAttribute(SessionKeyConst.USER_SESSION_CONATEXT, JSON.toJSONString(user));
        // 更新用户登录信息
        String loginIp = IPUtils.getIpAddr(request);
        userService.updateLoginInfo(user.getId(), new Date(), loginIp);
        UserDto dto = new UserDto();
        dto.setSid(session.getId().toString());
        BeanUtils.copyProperties(user, dto);
        //加密
        byte[] encrypt = aes.encrypt(JSON.toJSONString(user));
        dto.setEncryptUser(Base64Utils.encodeToString(encrypt));
        return new HttpResult(HttpResult.SUCCESS, dto, "登录成功");


    }

    @RequestMapping(value = "/notLogin", method = RequestMethod.POST)
    public HttpResult notLogin() {
        return new HttpResult(HttpResult.FAILED, "您尚未登陆…");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.POST)
    public HttpResult notRole() {
        return new HttpResult(HttpResult.FAILED, "您无权限…");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public HttpResult logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return new HttpResult(HttpResult.SUCCESS);
    }

    @GetMapping(value = "/unAuth")
    public void unAuth() {
        throw new CustomRunTimeException(HttpStatus.UNAUTHORIZED.value() + "");
    }

    @GetMapping("/getImgCode")
    public synchronized void getImgCode(HttpServletRequest req, HttpServletResponse response) {
        logger.info("【系统登陆】开始生成图像验证码……");
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(80, 26, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        String code = captcha.getCode();
        logger.info("【系统登陆】当前验证码：" + code);
        validateCode = code;
        try {
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
