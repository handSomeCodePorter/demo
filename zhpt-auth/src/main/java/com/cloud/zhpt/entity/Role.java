/*
 *
 * Role.java
 * @date 2019-09-08
 */
package com.cloud.zhpt.entity;

import java.util.Date;

public class Role {
    /**
     * ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String identify;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 是否可用
     */
    private Integer useable;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /*********************** 以下是自己添加字段 start ****************************/

    /**
     * 标识用户是否已拥有此角色 1 是 0 否
     */
    private Integer ownRole;

    /*********************** 以下是自己添加字段 end ****************************/
    /**
     * ID
     *
     * @return ID ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名称
     *
     * @return NAME 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 角色标识
     *
     * @return IDENTIFY 角色标识
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * 角色标识
     *
     * @param identify 角色标识
     */
    public void setIdentify(String identify) {
        this.identify = identify;
    }

    /**
     * 数据范围
     *
     * @return DATA_SCOPE 数据范围
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 数据范围
     *
     * @param dataScope 数据范围
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    /**
     * 备注说明
     *
     * @return REMARK 备注说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注说明
     *
     * @param remark 备注说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 是否可用
     *
     * @return USEABLE 是否可用
     */
    public Integer getUseable() {
        return useable;
    }

    /**
     * 是否可用
     *
     * @param useable 是否可用
     */
    public void setUseable(Integer useable) {
        this.useable = useable;
    }

    /**
     * 排序号
     *
     * @return SORT 排序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序号
     *
     * @param sort 排序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 创建时间
     *
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     *
     * @return MODIFY_TIME 最后修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     *
     * @param modifyTime 最后修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getOwnRole() {
        return ownRole;
    }

    public void setOwnRole(Integer ownRole) {
        this.ownRole = ownRole;
    }
}