package com.cloud.zhpt.admin.dto;

import java.io.Serializable;

/**
 * 消息查询对象
 *
 * @author houxiaohong
 * @ClassName: MessageQuery
 * @Description: TODO 消息查询对象
 */
public class MessageQuery implements Serializable {

    private static final long serialVersionUID = -9102273412944383432L;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息接收人
     */
    private Integer receivedBy;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(Integer receivedBy) {
        this.receivedBy = receivedBy;
    }

    @Override
    public String toString() {
        return "MessageQuery [type=" + type + ", receivedBy=" + receivedBy + "]";
    }

}
