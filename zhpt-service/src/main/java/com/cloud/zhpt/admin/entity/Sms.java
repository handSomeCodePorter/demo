package com.cloud.zhpt.admin.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机短信 sys_sms
 *
 * @author 32758
 * @date 2017-08-11 09:47:08
 */
public class Sms implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1404140729140461262L;

    /**
     * ID sys_sms.id
     */
    private Integer id;

    /**
     * 手机号码 sys_sms.phone
     */
    private String phone;

    /**
     * 短信内容 sys_sms.content
     */
    private String content;

    /**
     * 发送时间 sys_sms.send_time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date sendTime;

    /**
     * 过期时间 sys_sms.expires_time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date expiresTime;

    /**
     * 发送备注 sys_sms.remark
     */
    private String remark;

    /**
     * 状态 sys_sms.status
     */
    private String status;

    /**
     * 创建时间 sys_sms.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 sys_sms.modify_time
     */
    private Date modifyTime;

    /**************************** 以下是自己添加字段 start ******************************/

    /**
     * 接收人姓名（一个号码对多个用户，则拼接）
     */
    private String userNames;

    /**************************** 以上是自己添加字段 end ******************************/

    /**
     * ID sys_sms.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_sms.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 手机号码 sys_sms.phone
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码 sys_sms.phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 短信内容 sys_sms.content
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 短信内容 sys_sms.content
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 发送时间 sys_sms.send_time
     *
     * @return sendTime
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发送时间 sys_sms.send_time
     *
     * @param sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 过期时间 sys_sms.expires_time
     *
     * @return expiresTime
     */
    public Date getExpiresTime() {
        return expiresTime;
    }

    /**
     * 过期时间 sys_sms.expires_time
     *
     * @param expiresTime
     */
    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }

    /**
     * 发送备注 sys_sms.remark
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 发送备注 sys_sms.remark
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 状态 sys_sms.status
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 sys_sms.status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 创建时间 sys_sms.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 sys_sms.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间 sys_sms.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间 sys_sms.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    @Override
    public String toString() {
        return "Sms [id=" + id + ", phone=" + phone + ", content=" + content + ", sendTime=" + sendTime
                + ", expiresTime=" + expiresTime + ", remark=" + remark + ", status=" + status + ", createTime="
                + createTime + ", modifyTime=" + modifyTime + ", userNames=" + userNames + "]";
    }
}
