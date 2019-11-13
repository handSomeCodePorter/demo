package com.cloud.zhpt.admin.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机短信查询对象
 *
 * @author wanghongshuang
 * @ClassName: SmsQuery
 * @Description: TODO 手机短信查询对象
 */
public class SmsQuery implements Serializable {

    private static final long serialVersionUID = 3969989518315338769L;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 发送时间（开始）
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startSendTime;

    /**
     * 发送时间（结束）
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endSendTime;

    /**
     * 发送状态
     */
    private String status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartSendTime() {
        return startSendTime;
    }

    public void setStartSendTime(Date startSendTime) {
        this.startSendTime = startSendTime;
    }

    public Date getEndSendTime() {
        return endSendTime;
    }

    public void setEndSendTime(Date endSendTime) {
        this.endSendTime = endSendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SmsQuery [phone=" + phone + ", content=" + content + ", startSendTime=" + startSendTime
                + ", endSendTime=" + endSendTime + ", status=" + status + "]";
    }
}
