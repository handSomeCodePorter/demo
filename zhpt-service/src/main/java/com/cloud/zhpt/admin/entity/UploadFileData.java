package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 上传文件二进制数据 sys_upload_file_data
 *
 * @author 32758
 * @date 2017-08-10 16:06:50
 */
public class UploadFileData implements Serializable {

    private static final long serialVersionUID = -4873946480248457233L;

    /**
     * UUID sys_upload_file_data.uuid
     */
    private String uuid;

    /**
     * 二进制数据 sys_upload_file_data.data
     */
    private byte[] data;

    /**
     * UUID sys_upload_file_data.uuid
     *
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID sys_upload_file_data.uuid
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 二进制数据 sys_upload_file_data.data
     *
     * @return data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 二进制数据 sys_upload_file_data.data
     *
     * @param data
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UploadFileData [uuid=" + uuid + ", data=" + Arrays.toString(data) + "]";
    }
}
