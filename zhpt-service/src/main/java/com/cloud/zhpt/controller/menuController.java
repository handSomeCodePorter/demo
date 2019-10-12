package com.cloud.zhpt.controller;

import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.Service.MenuService;
import com.cloud.zhpt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName menuController
 * @Description
 * @Author SW
 * @Date 2019/9/29 18:21
 **/
@RestController
public class menuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/listTopMenu")
    public HttpResult listTopMenu(User user) {
        return new HttpResult(menuService.listMenuTopLevelByUserId(user.getId()));
    }

    @PostMapping("/welcome/test")
    public String test() {
        return "hello";
    }
}
