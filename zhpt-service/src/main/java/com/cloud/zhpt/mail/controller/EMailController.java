package com.cloud.zhpt.mail.controller;

import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.entity.User;
import com.cloud.zhpt.common.controller.BaseController;
import com.cloud.zhpt.mail.entity.EmailRecord;
import com.cloud.zhpt.mail.service.EMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MailController
 * @Description 邮件服务controller
 * @Author SW
 * @Date 2019/11/8 21:45
 **/
@RestController
@RequestMapping("/helper/mail")
public class EMailController extends BaseController {


    @Autowired
    EMailService mailService;


    @PostMapping("/sendEMail")
    public HttpResult sendEmail(@ModelAttribute("user") User user, EmailRecord record) throws Exception {
        record.setSender(user.getName());
        mailService.sendEmail(record);
        return new HttpResult(HttpResult.SUCCESS, "发送成功！");
    }

}
