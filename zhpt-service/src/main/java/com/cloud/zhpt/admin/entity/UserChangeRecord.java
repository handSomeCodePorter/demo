package com.cloud.zhpt.admin.entity;

/**
 * 人员变动记录表
 * sys_user_changerecord
 *
 * @author SW
 * @date 2018-09-17 19:06:41
 */
public class UserChangeRecord {
    /**
     * sys_user_changerecord.id
     */
    private Short id;

    /**
     * sys_user_changerecord.history_login_name
     */
    private String historyLoginName;

    /**
     * sys_user_changerecord.now_login_name
     */
    private String nowLoginName;

    /**
     * sys_user_changerecord.create_time
     */
    private String createTime;

    /**
     * sys_user_changerecord.id
     *
     * @return id
     */
    public Short getId() {
        return id;
    }

    /**
     * sys_user_changerecord.id
     *
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * sys_user_changerecord.history_login_name
     *
     * @return historyLoginName
     */
    public String getHistoryLoginName() {
        return historyLoginName;
    }

    /**
     * sys_user_changerecord.history_login_name
     *
     * @param historyLoginName
     */
    public void setHistoryLoginName(String historyLoginName) {
        this.historyLoginName = historyLoginName;
    }

    /**
     * sys_user_changerecord.now_login_name
     *
     * @return nowLoginName
     */
    public String getNowLoginName() {
        return nowLoginName;
    }

    /**
     * sys_user_changerecord.now_login_name
     *
     * @param nowLoginName
     */
    public void setNowLoginName(String nowLoginName) {
        this.nowLoginName = nowLoginName;
    }

    /**
     * sys_user_changerecord.create_time
     *
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * sys_user_changerecord.create_time
     *
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
