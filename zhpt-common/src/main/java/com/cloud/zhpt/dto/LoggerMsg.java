package com.cloud.zhpt.dto;

import lombok.*;

/**
 * @ClassName Log
 * @Description
 * @Author SW
 * @Date 2019/9/8 13:34
 **/
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoggerMsg {

    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private String exception;
    private String cause;



}
