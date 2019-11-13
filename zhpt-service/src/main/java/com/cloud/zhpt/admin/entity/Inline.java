package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户表
 * sys_inline
 *
 * @author 32758
 * @date 2018-01-04 10:40:42
 */
public class Inline implements Serializable {

    private static final long serialVersionUID = 1471611999676331843L;

    /**
     * 用户ID
     * sys_inline.user_id
     */
    private Integer userId;

    /**
     * 用户账号
     * sys_inline.login_name
     */
    private String loginName;

    /**
     * 心跳时间
     * sys_inline.heartbeat
     */
    private Date heartbeat;

    /**
     * 用户ID
     * sys_inline.user_id
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * sys_inline.user_id
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户账号
     * sys_inline.login_name
     *
     * @return loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 用户账号
     * sys_inline.login_name
     *
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 心跳时间
     * sys_inline.heartbeat
     *
     * @return heartbeat
     */
    public Date getHeartbeat() {
        return heartbeat;
    }

    /**
     * 心跳时间
     * sys_inline.heartbeat
     *
     * @param heartbeat
     */
    public void setHeartbeat(Date heartbeat) {
        this.heartbeat = heartbeat;
    }

    @Override
    public String toString() {
        return "Inline [userId=" + userId + ", loginName=" + loginName + ", heartbeat=" + heartbeat + "]";
    }
}
