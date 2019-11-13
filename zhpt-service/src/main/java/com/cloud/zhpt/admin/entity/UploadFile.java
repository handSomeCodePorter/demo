package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 上传的文件 sys_upload_file
 *
 * @author 32758
 * @date 2017-05-18 20:09:32
 */
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 4181359511213565746L;

    /**
     * ID sys_upload_file.id
     */
    private Integer id;

    /**
     * UUID sys_upload_file.uuid
     */
    private String uuid;

    /**
     * 文件名称 sys_upload_file.name
     */
    private String name;

    /**
     * 文件后缀 sys_upload_file.suffix
     */
    private String suffix;

    /**
     * 文件路径 sys_upload_file.path
     */
    private String path;

    /**
     * 文件大小(BYTE) sys_upload_file.sizeb
     */
    private Long sizeb;

    /**
     * 文件大小(MB) sys_upload_file.sizem
     */
    private String sizem;

    /**
     * 创建时间 sys_upload_file.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 sys_upload_file.modify_time
     */
    private Date modifyTime;

    /**
     * ID sys_upload_file.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_upload_file.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * UUID sys_upload_file.uuid
     *
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID sys_upload_file.uuid
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 文件名称 sys_upload_file.name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 文件名称 sys_upload_file.name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 文件后缀 sys_upload_file.suffix
     *
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 文件后缀 sys_upload_file.suffix
     *
     * @param suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 文件路径 sys_upload_file.path
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 文件路径 sys_upload_file.path
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 文件大小(BYTE) sys_upload_file.sizeb
     *
     * @return sizeb
     */
    public Long getSizeb() {
        return sizeb;
    }

    /**
     * 文件大小(BYTE) sys_upload_file.sizeb
     *
     * @param sizeb
     */
    public void setSizeb(Long sizeb) {
        this.sizeb = sizeb;
    }

    /**
     * 文件大小(MB) sys_upload_file.sizem
     *
     * @return sizem
     */
    public String getSizem() {
        return sizem;
    }

    /**
     * 文件大小(MB) sys_upload_file.sizem
     *
     * @param sizem
     */
    public void setSizem(String sizem) {
        this.sizem = sizem;
    }

    /**
     * 创建时间 sys_upload_file.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 sys_upload_file.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间 sys_upload_file.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间 sys_upload_file.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "UploadFile [id=" + id + ", uuid=" + uuid + ", name=" + name + ", suffix=" + suffix + ", path=" + path
                + ", sizeb=" + sizeb + ", sizem=" + sizem + ", createTime=" + createTime + ", modifyTime=" + modifyTime
                + "]";
    }
}
