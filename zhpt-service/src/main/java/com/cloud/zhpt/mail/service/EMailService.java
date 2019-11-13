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
     * 邮件队列是否运行
     */
    private boolean QUEUE_IS_RUN = false;

    /**
     * 邮件超时间隔
     */
    private static long TIMEOUT_INTERVAL = 1 * 60 * 1000;

    @Transactional
    public void sendEmail(EmailRecord record) throws InterruptedException, CustomRunTimeException {
        logger.info("sendEmail: 邮箱放入队列……");
        //放入队列
        boolean is_offer = RedisCacheUtils.lLeftPush(QUEUE_NAME, JSON.toJSONBytes(record));
        logger.info("sendEmail: 当前待发送邮件：" + RedisCacheUtils.lGetQueueSize(QUEUE_NAME));
        if (!is_offer) {
            throw new CustomRunTimeException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "服务器发送邮件繁忙，请稍后再试");
        }
        QUEUE_IS_RUN = true;
        executor.execute(new Runnable() {
            @Override
            public void run() {
                long timeStamp = System.currentTimeMillis();
                while (QUEUE_IS_RUN) {
                    try {
                        long time_out = timeStamp + TIMEOUT_INTERVAL;
                        if (System.currentTimeMillis() > time_out) {
                            logger.info("sendEmail: 线程超时退出……");
                            QUEUE_IS_RUN = false;
                            break;
                        }
                        if (RedisCacheUtils.lGetQueueSize(QUEUE_NAME) == 0) {//如果队列为空则线程休眠一秒
                            Thread.sleep(1000);
                            continue;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    EmailRecord mail = JSON.parseObject((byte[]) RedisCacheUtils.lRightPop(QUEUE_NAME, 1), EmailRecord.class);
                    timeStamp = System.currentTimeMillis();
                    String[] tosArr = mail.getAddress().split(";");
                    ArrayList<String> tos = CollUtil.newArrayList(tosArr);
                    int send_status = CommonState.YES; //发送状态
                    try {
                        //发送邮件
                        MailUtil.send(tos, mail.getTitle(), mail.getContent(), true);
                        logger.info("sendEmail: 发送至邮箱：" + mail.getAddress());
                    } catch (Exception e) {
                        e.printStackTrace();
                        send_status = CommonState.NO;
                    } finally {
                        mail.setSendStatus(send_status);
                        //保存到数据库
                        emailRecordDao.insertSelective(mail);
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
