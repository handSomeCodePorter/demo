package com.cloud.zhpt.common.controller;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.cloud.zhpt.Const.SessionKeyConst;
import com.cloud.zhpt.admin.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName BaseController
 * @Description
 * @Author SW
 * @Date 2019/10/26 17:44
 **/
public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空 true代表可以为空
         *
         * 解决前端日期传输到后端错误
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @ModelAttribute("user")
    public User getSessionUser() {
        Session session = SecurityUtils.getSubject().getSession();
        User user = JSON.parseObject(session.getAttribute(SessionKeyConst.USER_SESSION_CONATEXT).toString(), User.class);
        return user;
    }
}
