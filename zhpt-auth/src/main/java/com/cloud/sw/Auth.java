package com.cloud.sw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Auth
 * @Description
 * @Author SW
 * @Date 2019/8/13 17:48
 **/
@PropertySource("classpath:${zhpt.cloud.resources.locations}")
@EnableEurekaClient
@SpringBootApplication
public class Auth {
    private static  Logger logger = LoggerFactory.getLogger(Auth.class);
    public static void main(String[] args) {
        logger.info("##################################################################################");
        SpringApplication.run(Auth.class);
    }

}
