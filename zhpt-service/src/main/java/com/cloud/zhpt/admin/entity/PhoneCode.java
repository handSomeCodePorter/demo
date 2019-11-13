package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机验证码
 * sys_phone_code
 *
 * @author hql
 * @date 2018-01-03 15:23:02
 */
public class PhoneCode implements Serializable {

    private static final long serialVersionUID = 8119326887359574608L;

    //找回密码
    public final static int TYPE_1 = 1;

    /**
     * ID
     * sys_phone_code.id
     */
    private Integer id;

    /**
     * 手机号码
     * sys_phone_code.phone
     */
    private String phone;

    /**
     * 验证码
     * sys_phone_code.code
     */
    private Integer code;

    /**
     * 类型
     * sys_phone_code.type
     */
    private Integer type;

    /**
     * 过期时间
     * sys_phone_code.expires_time
     */
    private Date expiresTime;

    /**
     * 创建时间
     * sys_phone_code.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间
     * sys_phone_code.modify_time
     */
    private Date modifyTime;

    /**
     * ID
     * sys_phone_code.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * sys_phone_code.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 手机号码
     * sys_phone_code.phone
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * sys_phone_code.phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 验证码
     * sys_phone_code.code
     *
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 验证码
     * sys_phone_code.code
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 类型
     * sys_phone_code.type
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
     * sys_phone_code.type
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 过期时间
     * sys_phone_code.expires_time
     *
     * @return expiresTime
     */
    public Date getExpiresTime() {
        return expiresTime;
    }

    /**
     * 过期时间
     * sys_phone_code.expires_time
     *
     * @param expiresTime
     */
    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }

    /**
     * 创建时间
     * sys_phone_code.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * sys_phone_code.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * sys_phone_code.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     * sys_phone_code.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "PhoneCode [id=" + id + ", phone=" + phone + ", code=" + code + ", type=" + type + ", expiresTime="
                + expiresTime + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
