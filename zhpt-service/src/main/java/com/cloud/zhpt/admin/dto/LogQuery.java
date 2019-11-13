package com.cloud.zhpt.admin.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志查询对象
 *
 * @author houxiaohong
 * @ClassName: LogQuery
 * @Description: TODO 系统日志查询对象
 */
//@Document(collection="sys_log")
public class LogQuery implements Serializable {

    private static final long serialVersionUID = -4280740226076711632L;

    /**
     * 操作用户
     */
    private String userName;

    /**
     * IP地址
     */
    private String remoteAddr;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 只查询异常信息
     */
    private boolean queryException;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isQueryException() {
        return queryException;
    }

    public void setQueryException(boolean queryException) {
        this.queryException = queryException;
    }

    @Override
    public String toString() {
        return "LogQuery [userName=" + userName + ", remoteAddr=" + remoteAddr + ", startTime=" + startTime
                + ", endTime=" + endTime + ", queryException=" + queryException + "]";
    }

}
