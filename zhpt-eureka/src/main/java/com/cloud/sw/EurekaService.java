package com.cloud.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaService
 * @Description
 * @Author SW
 * @Date 2019/8/14 15:11
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaService {

    public static void main(String[] args) {
       SpringApplication.run(EurekaService.class);
    }
}
