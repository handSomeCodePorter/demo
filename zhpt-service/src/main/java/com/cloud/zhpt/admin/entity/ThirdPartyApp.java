package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 第三方应用
 * sys_third_party_app
 *
 * @author 32758
 * @date 2017-12-25 11:32:09
 */
public class ThirdPartyApp implements Serializable {

    private static final long serialVersionUID = -312610154418196648L;

    /**
     * ID
     * sys_third_party_app.id
     */
    private Integer id;

    /**
     * 应用标识
     * sys_third_party_app.app_key
     */
    private String appKey;

    /**
     * 名称
     * sys_third_party_app.app_name
     */
    private String appName;

    /**
     * 备注
     * sys_third_party_app.remark
     */
    private String remark;

    /**
     * 创建时间
     * sys_third_party_app.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间
     * sys_third_party_app.modify_time
     */
    private Date modifyTime;

    /**
     * ID
     * sys_third_party_app.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * sys_third_party_app.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 应用标识
     * sys_third_party_app.app_key
     *
     * @return appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 应用标识
     * sys_third_party_app.app_key
     *
     * @param appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * 名称
     * sys_third_party_app.app_name
     *
     * @return appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 名称
     * sys_third_party_app.app_name
     *
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 备注
     * sys_third_party_app.remark
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * sys_third_party_app.remark
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 创建时间
     * sys_third_party_app.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * sys_third_party_app.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * sys_third_party_app.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     * sys_third_party_app.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ThirdPartyApp [id=" + id + ", appKey=" + appKey + ", appName=" + appName + ", remark=" + remark
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
