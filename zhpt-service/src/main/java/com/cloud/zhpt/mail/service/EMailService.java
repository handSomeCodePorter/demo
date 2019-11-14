package com.cloud.zhpt.mail.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSON;
import com.cloud.zhpt.Const.CommonState;
import com.cloud.zhpt.Utils.RedisCacheUtils;
import com.cloud.zhpt.exception.CustomRunTimeException;
import com.cloud.zhpt.mail.dao.EmailRecordDao;
import com.cloud.zhpt.mail.entity.EmailRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/**
 * @ClassName MailService
 * @Description
 * @Author SW
 * @Date 2019/11/8 21:47
 **/
@Service
public class EMailService {
    private Logger logger = LoggerFactory.getLogger(EMailService.class);

    @Autowired
    EmailRecordDao emailRecordDao;

    @Resource(name = "threadPoolTaskExecutor")
    Executor executor;

    private static final String QUEUE_NAME = "MAIL_QUEUE";

    /**
     * 邮件失败重复发送次数
     */
    private static final  int SEND_COUNT = 6;

    /**
     * 邮件超时间隔
     */
    private static long TIMEOUT_INTERVAL = 1 * 60 * 1000;

    @Transactional
    public void sendEmail(EmailRecord record) throws InterruptedException, CustomRunTimeException {
        record.setSendCount(0);
        logger.info("sendEmail: 邮箱放入队列……");
        //放入队列
        boolean is_offer = RedisCacheUtils.lLeftPush(QUEUE_NAME, JSON.toJSONBytes(record));
        logger.info("sendEmail: 当前待发送邮件：" + RedisCacheUtils.lGetQueueSize(QUEUE_NAME));
        if (!is_offer) {
            throw new CustomRunTimeException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "服务器发送邮件繁忙，请稍后再试");
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (RedisCacheUtils.lGetQueueSize(QUEUE_NAME) > 0) {
                    EmailRecord mail = JSON.parseObject((byte[]) RedisCacheUtils.lRightPop(QUEUE_NAME, 1), EmailRecord.class);
                    String[] tosArr = mail.getAddress().split(";");
                    ArrayList<String> tos = CollUtil.newArrayList(tosArr);
                    try {
                        logger.info("sendEmail: 发送至邮箱：" + mail.getAddress());
                        //发送邮件
                        MailUtil.send(tos, mail.getTitle(), mail.getContent(), true);
                        logger.info("sendEmail: " + mail.getAddress() + "发送成功");
                        mail.setSendStatus(CommonState.YES);
                        //保存到数据库
                        emailRecordDao.insertSelective(mail);
                    } catch (Exception e) {
                        if(mail.getSendCount() <=  SEND_COUNT){ //重新发送
                            mail.setSendCount(mail.getSendCount() + 1);
                            RedisCacheUtils.lLeftPush(QUEUE_NAME, JSON.toJSONBytes(mail)); //小于限定发送次数则继续发送
                        }else{ //保存到数据库
                            mail.setSendStatus(CommonState.NO);
                            //保存到数据库
                            emailRecordDao.insertSelective(mail);
                        }
                        e.printStackTrace();
                    } finally {
                        try {
                            Thread.sleep(1000); //发送一个邮件休息1秒，防止发送过快，导致主油箱被锁定
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }


}
