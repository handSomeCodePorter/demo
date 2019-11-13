package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典 sys_dict
 *
 * @author
 * @date 2017-05-03 19:20:08
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = 1238471231877754250L;

    /**
     * ID sys_dict.id
     */
    private Integer id;

    /**
     * 字典类型 sys_dict.type
     */
    private String type;

    /**
     * 字典值 sys_dict.value
     */
    private String value;

    /**
     * 标签 sys_dict.label
     */
    private String label;

    /**
     * 描述 sys_dict.description
     */
    private String description;

    /**
     * 排序 sys_dict.sort
     */
    private Integer sort;

    /**
     * 创建时间 sys_dict.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 sys_dict.modify_time
     */
    private Date modifyTime;

    /**
     * 父级ID sys_dict.parent_id
     */
    private Integer parentId;

    /**
     * ID sys_dict.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_dict.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 字典类型 sys_dict.type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 字典类型 sys_dict.type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 字典值 sys_dict.value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 字典值 sys_dict.value
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 标签 sys_dict.label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 标签 sys_dict.label
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 描述 sys_dict.description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述 sys_dict.description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 排序 sys_dict.sort
     *
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序 sys_dict.sort
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 创建时间 sys_dict.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 sys_dict.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间 sys_dict.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间 sys_dict.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 父级ID sys_dict.parent_id
     *
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级ID sys_dict.parent_id
     *
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Dict [id=" + id + ", type=" + type + ", value=" + value + ", label=" + label + ", description="
                + description + ", sort=" + sort + ", createTime=" + createTime + ", modifyTime=" + modifyTime
                + ", parentId=" + parentId + "]";
    }

}
