/*
*
* EmailRecord.java
* @date 2019-11-13
*/
package com.cloud.zhpt.mail.entity;

import java.util.Date;

public class EmailRecord {
    /**
     * ID
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发送人
     */
    private String sender;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 收件地址
     */
    private String address;

    /**
     * 收件时间
     */
    private Date receiveTime;

    /**
     * 邮件类型
     */
    private Integer mailType;

    /**
     * 1成功、0 失败
     */
    private Integer sendStatus;

    /**
     * ID
     * @return ID ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 标题
     * @return TITLE 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容
     * @return CONTENT 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 发送人
     * @return SENDER 发送人
     */
    public String getSender() {
        return sender;
    }

    /**
     * 发送人
     * @param sender 发送人
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * 发送时间
     * @return SEND_TIME 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发送时间
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 收件地址
     * @return ADDRESS 收件地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 收件地址
     * @param address 收件地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 收件时间
     * @return RECEIVE_TIME 收件时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 收件时间
     * @param receiveTime 收件时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 邮件类型
     * @return MAIL_TYPE 邮件类型
     */
    public Integer getMailType() {
        return mailType;
    }

    /**
     * 邮件类型
     * @param mailType 邮件类型
     */
    public void setMailType(Integer mailType) {
        this.mailType = mailType;
    }

    /**
     * 1成功、0 失败
     * @return SEND_STATUS 1成功、0 失败
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 1成功、0 失败
     * @param sendStatus 1成功、0 失败
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}