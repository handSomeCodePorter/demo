package com.cloud.zhpt.warper;


import com.cloud.zhpt.admin.dto.LoggerMsg;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName LoggerQueue
 * @Description
 * @Author SW
 * @Date 2019/9/8 13:30
 **/
public class LoggerQueue {

    public static  final int QUEUE_MAX_SIZE = 10000;

    private static LoggerQueue loggerQueue = new LoggerQueue();

    private static BlockingQueue<LoggerMsg> blockingQueue = new LinkedBlockingQueue<LoggerMsg>();

    public static  LoggerQueue getInstance(){
        return  loggerQueue;
    }

    /**
     * 消息加入队列
     * @param loggerMsg
     * @return
     */
    public boolean push(LoggerMsg loggerMsg) {
        return blockingQueue.add(loggerMsg);
    }

    /**
     * 消息出队
     * @return
     */
    public LoggerMsg poll() {
        LoggerMsg logger = null;
        try {
            logger = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
