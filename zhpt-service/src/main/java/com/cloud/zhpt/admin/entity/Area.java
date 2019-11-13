package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 行政区域 sys_area
 *
 * @author
 * @date 2017-05-03 19:20:08
 */
public class Area implements Serializable {

    private static final long serialVersionUID = 9187941170519765558L;

    /**
     * ID sys_area.id
     */
    private Integer id;

    /**
     * 区域码 sys_area.code
     */
    private String code;

    /**
     * 区域名称 sys_area.name
     */
    private String name;

    /**
     * 区域类型 sys_area.type
     */
    private String type;

    /**
     * 排序 sys_area.sort
     */
    private Integer sort;

    /**
     * 备注说明 sys_area.remark
     */
    private String remark;

    /**
     * 创建时间 sys_area.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 sys_area.modify_time
     */
    private Date modifyTime;

    /**
     * 父级ID sys_area.parent_id
     */
    private Integer parentId;

    /*********************** 以下是自己添加字段 strat ****************************/

    /**
     * 区域层级
     */
    private Integer areaLevel;

    /**
     * 是否是叶子节点
     */
    private Integer leaf;

    /**
     * 区域路径全称
     */
    private String pathName;

    /**
     * 区域所在根节点Id
     */
    private Integer rootId;

    /**
     * 区域所在根节点名称
     */
    private String rootName;

    /**
     * 父级区域名称
     */
    private String parentName;

    /*********************** 以上是自己添加字段 end ****************************/

    /**
     * ID sys_area.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_area.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 区域码 sys_area.code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 区域码 sys_area.code
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 区域名称 sys_area.name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 区域名称 sys_area.name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 区域类型 sys_area.type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 区域类型 sys_area.type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 排序 sys_area.sort
     *
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序 sys_area.sort
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 备注说明 sys_area.remark
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注说明 sys_area.remark
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 创建时间 sys_area.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 sys_area.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间 sys_area.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间 sys_area.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 父级ID sys_area.parent_id
     *
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级ID sys_area.parent_id
     *
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "Area [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + ", sort=" + sort
                + ", remark=" + remark + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", parentId="
                + parentId + ", areaLevel=" + areaLevel + ", leaf=" + leaf + ", pathName=" + pathName + ", rootId="
                + rootId + ", rootName=" + rootName + ", parentName=" + parentName + "]";
    }

}
