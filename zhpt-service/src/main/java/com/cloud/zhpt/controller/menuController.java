package com.cloud.zhpt.controller;

import cn.hutool.core.lang.Console;
import com.cloud.zhpt.Const.SessionKeyConst;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.Service.MenuService;
import com.cloud.zhpt.config.Shiro.RedisSessionDao;
import com.cloud.zhpt.entity.User;
import com.cloud.zhpt.exception.CustomRunTimeException;
import com.cloud.zhpt.exception.ExceptionCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName menuController
 * @Description
 * @Author SW
 * @Date 2019/9/29 18:21
 **/
@RequestMapping("/menu")
@RestController
public class menuController {

    @Autowired
    MenuService menuService;

    @Autowired
    RedisSessionDao redisSessionDao;

    @RequiresPermissions(value = {"msg:find"})
    @RequiresRoles("admin")
    @PostMapping("/listTopMenu")
    public HttpResult listTopMenu(User user, HttpServletRequest request) {

        System.out.println("dddd");

        return new HttpResult(HttpResult.SUCCESS);
    }

    @PostMapping("/welcome/test")
    public String test() {
        return "hello";
    }
}
