package com.cloud.zhpt.admin.dto;

import java.io.Serializable;

/**
 * 字典查询对象
 *
 * @author wanghongshuang
 * @ClassName: DictQuery
 * @Description: TODO 字典查询对象
 */
public class DictQuery implements Serializable {

    private static final long serialVersionUID = 4106249826289628399L;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DictQuery [type=" + type + ", description=" + description + "]";
    }

}
