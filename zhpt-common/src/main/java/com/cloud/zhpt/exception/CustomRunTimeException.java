package com.cloud.zhpt.exception;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName CustomRunTimeException
 * @Description
 * @Author SW
 * @Date 2019/10/17 10:26
 **/

@Getter
public class CustomRunTimeException extends RuntimeException {

    @Autowired
    Environment environment;

    private String code;

    private String message;

    private final String EX_PREFIX = "EX_";

    public CustomRunTimeException(String code, String message) {
        super();
        this.code = code;
        this.message = message;

    }

    public CustomRunTimeException(String code) {
        super();
        Properties properties = new Properties();

        try {
            Reader in = new InputStreamReader(CustomRunTimeException.class.getClassLoader().getResourceAsStream("exception.properties"), "utf8");
            properties.load(in);
            this.message = properties.getProperty(EX_PREFIX + code);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.code = code;

    }


}
