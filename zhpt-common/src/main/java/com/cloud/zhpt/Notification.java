package com.cloud.zhpt;

import java.io.Serializable;

/**
 * @ClassName Notification
 * @Description
 * @Author SW
 * @Date 2019/8/30 21:30
 **/
public class Notification<T> implements Serializable {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "failed";

    private String status;

    private T data;

    private String Msg;

    public Notification(String status, T data, String msg) {
        this.status = status;
        this.data = data;
        Msg = msg;
    }

    public Notification(String status, String msg) {
        this.status = status;
        Msg = msg;
    }

    public Notification(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }



    @Override
    public String toString() {
        return "Notification{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", Msg='" + Msg + '\'' +
                '}';
    }
}
