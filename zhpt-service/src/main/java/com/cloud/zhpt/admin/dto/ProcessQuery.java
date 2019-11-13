package com.cloud.zhpt.admin.dto;

import java.io.Serializable;

/**
 * 流程查询对象
 *
 * @author wanghongshuang
 * @ClassName: ProcessQuery
 * @Description: TODO 流程查询对象
 */
public class ProcessQuery implements Serializable {

    private static final long serialVersionUID = -4821439255926116981L;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 流程实例名称
     */
    private String processInstanceName;

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    @Override
    public String toString() {
        return "ProcessQuery [processInstanceId=" + processInstanceId + ", processInstanceName=" + processInstanceName
                + "]";
    }

}
