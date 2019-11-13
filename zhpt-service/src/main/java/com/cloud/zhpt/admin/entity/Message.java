package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统消息 sys_message
 *
 * @author 32758
 * @date 2017-07-24 10:14:14
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 7629417052366697653L;

    /**
     * ID sys_message.id
     */
    private Integer id;

    /**
     * 消息类型
     * sys_message.type
     */
    private String type;

    /**
     * 消息内容 sys_message.content
     */
    private String content;

    /**
     * 消息接收人 sys_message.received_by
     */
    private Integer receivedBy;

    /**
     * 已读标志 sys_message.read
     */
    private Integer read;

    /**
     * 过期时间 sys_message.exp_date
     */
    private Date expDate;

    /**
     * 创建时间 sys_message.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 sys_message.modify_time
     */
    private Date modifyTime;

    /**
     * ID sys_message.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_message.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 消息类型
     * sys_message.type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 消息类型
     * sys_message.type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 消息内容 sys_message.content
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 消息内容 sys_message.content
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 消息接收人 sys_message.received_by
     *
     * @return receivedBy
     */
    public Integer getReceivedBy() {
        return receivedBy;
    }

    /**
     * 消息接收人 sys_message.received_by
     *
     * @param receivedBy
     */
    public void setReceivedBy(Integer receivedBy) {
        this.receivedBy = receivedBy;
    }

    /**
     * 已读标志 sys_message.read
     *
     * @return read
     */
    public Integer getRead() {
        return read;
    }

    /**
     * 已读标志 sys_message.read
     *
     * @param read
     */
    public void setRead(Integer read) {
        this.read = read;
    }

    /**
     * sys_message.exp_date
     *
     * @return expDate
     */
    public Date getExpDate() {
        return expDate;
    }

    /**
     * sys_message.exp_date
     *
     * @param expDate
     */
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    /**
     * 创建时间 sys_message.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 sys_message.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间 sys_message.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间 sys_message.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", content=" + content + ", receivedBy=" + receivedBy + ", read=" + read
                + ", expDate=" + expDate + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
