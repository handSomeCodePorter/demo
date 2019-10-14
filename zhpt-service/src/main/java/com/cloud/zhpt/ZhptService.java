package com.cloud.zhpt;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
@ServletComponentScan
@SpringBootApplication
public class ZhptService {
    private static Logger logger = LoggerFactory.getLogger(ZhptService.class);
    public static void main(String[] args) {
        SpringApplication.run(ZhptService.class);
    }

}
