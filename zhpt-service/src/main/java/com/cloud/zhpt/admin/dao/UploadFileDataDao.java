package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.UploadFileData;

public interface UploadFileDataDao {
    /**
     * 插入数据
     * sys_upload_file_data
     *
     * @param record
     * @return int
     */
    int insert(UploadFileData record);

    /**
     * 插入数据，动态字段
     * sys_upload_file_data
     *
     * @param record
     * @return int
     */
    int insertSelective(UploadFileData record);

    ////////////////////////////////////////////////////////////////

    /**
     * 根据uuid获取文件数据
     *
     * @param uuid
     * @return UploadFileData
     */
    UploadFileData getFileDataByUUID(String uuid);
}
