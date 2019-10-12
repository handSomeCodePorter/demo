/*
*
* User.java
* @date 2019-09-08
*/
package com.cloud.zhpt.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 职务
     */
    private String duty;

    /**
     * 岗位
     */
    private String job;

    /**
     * 拼音首字母
     */
    private String spellFirst;

    /**
     * 拼音全拼
     */
    private String spellFull;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 微信
     */
    private String weixin;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 是否锁定
     */
    private Integer locked;

    /**
     * 廉政教育角色
     */
    private String eduRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /**
     * 删除标志
     */
    private Integer deleted;

    /**
     * 机构ID
     */
    private Integer organId;

    /**
     * 是否是党员
     */
    private Integer partyer;

    /**
     * 最后弹出岗位风险时间
     */
    private Date lastRiskTime;


    ////////////////////////////////////////////////////////////////////

    /**
     * 部门名称
     */
    private String organName;


    /**
     * sessionId
     */
    private String sid;


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
     * 登录账号
     * @return LOGIN_NAME 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录账号
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 密码
     * @return PASSWORD 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户名称
     * @return NAME 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名称
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 职务
     * @return DUTY 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 职务
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 岗位
     * @return JOB 岗位
     */
    public String getJob() {
        return job;
    }

    /**
     * 岗位
     * @param job 岗位
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 拼音首字母
     * @return SPELL_FIRST 拼音首字母
     */
    public String getSpellFirst() {
        return spellFirst;
    }

    /**
     * 拼音首字母
     * @param spellFirst 拼音首字母
     */
    public void setSpellFirst(String spellFirst) {
        this.spellFirst = spellFirst;
    }

    /**
     * 拼音全拼
     * @return SPELL_FULL 拼音全拼
     */
    public String getSpellFull() {
        return spellFull;
    }

    /**
     * 拼音全拼
     * @param spellFull 拼音全拼
     */
    public void setSpellFull(String spellFull) {
        this.spellFull = spellFull;
    }

    /**
     * 手机号码
     * @return PHONE 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 出生日期
     * @return BIRTHDAY 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * QQ号码
     * @return QQ QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * QQ号码
     * @param qq QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 微信
     * @return WEIXIN 微信
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * 微信
     * @param weixin 微信
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * 头像
     * @return AVATAR 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 最后登录IP
     * @return LAST_LOGIN_IP 最后登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登录IP
     * @param lastLoginIp 最后登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 最后登录时间
     * @return LAST_LOGIN_TIME 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 是否锁定
     * @return LOCKED 是否锁定
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 是否锁定
     * @param locked 是否锁定
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 廉政教育角色
     * @return EDU_ROLE 廉政教育角色
     */
    public String getEduRole() {
        return eduRole;
    }

    /**
     * 廉政教育角色
     * @param eduRole 廉政教育角色
     */
    public void setEduRole(String eduRole) {
        this.eduRole = eduRole;
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * @return MODIFY_TIME 最后修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     * @param modifyTime 最后修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 删除标志
     * @return DELETED 删除标志
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 删除标志
     * @param deleted 删除标志
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 机构ID
     * @return ORGAN_ID 机构ID
     */
    public Integer getOrganId() {
        return organId;
    }

    /**
     * 机构ID
     * @param organId 机构ID
     */
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    /**
     * 是否是党员
     * @return PARTYER 是否是党员
     */
    public Integer getPartyer() {
        return partyer;
    }

    /**
     * 是否是党员
     * @param partyer 是否是党员
     */
    public void setPartyer(Integer partyer) {
        this.partyer = partyer;
    }

    /**
     * 最后弹出岗位风险时间
     * @return LAST_RISK_TIME 最后弹出岗位风险时间
     */
    public Date getLastRiskTime() {
        return lastRiskTime;
    }

    /**
     * 最后弹出岗位风险时间
     * @param lastRiskTime 最后弹出岗位风险时间
     */
    public void setLastRiskTime(Date lastRiskTime) {
        this.lastRiskTime = lastRiskTime;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }
}