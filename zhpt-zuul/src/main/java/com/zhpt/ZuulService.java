package com.zhpt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZhptZuulService
 * @Description
 * @Author SW
 * @Date 2019/9/30 15:20
 **/
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulService {

    public static void main(String[] args) {

        SpringApplication.run(ZuulService.class, args);
    }
}
