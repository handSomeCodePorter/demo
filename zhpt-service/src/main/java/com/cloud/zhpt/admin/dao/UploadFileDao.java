package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.UploadFile;


public interface UploadFileDao {
    /**
     * 根据主键删除数据 sys_upload_file
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据 sys_upload_file
     *
     * @param record
     * @return int
     */
    int insert(UploadFile record);

    /**
     * 插入数据，动态字段 sys_upload_file
     *
     * @param record
     * @return int
     */
    int insertSelective(UploadFile record);

    /**
     * 根据主键查询数据 sys_upload_file
     *
     * @param id
     * @return UploadFile
     */
    UploadFile selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段 sys_upload_file
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(UploadFile record);

    /**
     * 根据主键更新数据 sys_upload_file
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(UploadFile record);

    ////////////////////////////////////////////////////////////////

    /**
     * 根据uuid获取附件信息
     *
     * @param uuid
     * @return UploadFile
     */
    UploadFile getFileByUUID(String uuid);

    /**
     * 根据文件id查询文件UUID
     *
     * @param id
     * @return String
     */
    String getFileUUIDById(Integer id);
}
