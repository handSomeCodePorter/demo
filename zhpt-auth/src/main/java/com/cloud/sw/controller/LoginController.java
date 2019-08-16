package com.cloud.sw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description
 * @Author SW
 * @Date 2019/8/15 15:41
 **/
@RestController
public class LoginController {

    @GetMapping("/hello")
    public  String hello(){
        return "hi";
    }





}
