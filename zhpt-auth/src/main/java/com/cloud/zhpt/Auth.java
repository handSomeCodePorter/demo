package com.cloud.zhpt;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @ClassName Auth
 * @Description
 * @Author SW
 * @Date 2019/8/13 17:48
 **/
@PropertySource("classpath:${zhpt.cloud.resources.jdbc.locations}")
@PropertySource("classpath:${zhpt.cloud.resources.redis.locations}")
@MapperScan(basePackages = "com.cloud.zhpt.Dao")
@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class Auth {
    private static  Logger logger = LoggerFactory.getLogger(Auth.class);
    public static void main(String[] args) {
        SpringApplication.run(Auth.class);
    }

}
