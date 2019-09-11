package com.cloud.zhpt.controller;

import cn.hutool.Hutool;
import com.cloud.zhpt.Notification;
import com.cloud.zhpt.Service.UserService;
import com.cloud.zhpt.Utils.IPUtils;
import com.cloud.zhpt.entity.User;
import com.cloud.zhpt.warper.WebSocketServer;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    UserService userService;

    @Autowired
    WebSocketServer webSocketServer;

    @PostMapping("/login")
    public Notification Login(String userName, String password, boolean rememberMe,HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
//            this.setNotification(NotificationType.ERROR, "用户名或者密码不能为空，请重新登录。", DialogType.MSG);
//            return new ModelAndView("redirect:/login.jsp");
        }
        String passwordMD5 = password;
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passwordMD5);
        Subject subject = SecurityUtils.getSubject();
        // 执行验证
        subject.login(token);
        // 用户验证成功
        // 将用户信息保存到session
        User user = userService.getUserByLoginName(userName);

        session.setAttribute("USER_CONTEXT", user);

        // 更新用户登录信息
        String loginIp = IPUtils.getIpAddr(request);
        userService.updateLoginInfo(user.getId(), new Date(), loginIp);

        return new Notification(Notification.SUCCESS, user);

    }




    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public Notification notLogin() {
        return new Notification(Notification.FAILED,"您尚未登陆…");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public Notification notRole() {
        return new Notification(Notification.FAILED,"您无权限…");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Notification logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return new Notification(Notification.SUCCESS,"成功退出…");
    }








}
