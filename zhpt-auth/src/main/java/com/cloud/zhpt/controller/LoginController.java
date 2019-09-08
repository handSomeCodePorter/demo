package com.cloud.zhpt.controller;

import com.cloud.zhpt.Notification;
import com.cloud.zhpt.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description
 * @Author SW
 * @Date 2019/8/15 15:41
 **/
@RestController
public class LoginController {

    @PostMapping("/login")
    public Notification Login(HttpServletRequest request, String userName, String password, boolean rememberMe){
        User user = new User();
        user.setName("zhangsan");
        return new Notification(Notification.SUCCESS, user);

    }


    @GetMapping("/hello")
    public  String hello(){
        return "hi";
    }





}
