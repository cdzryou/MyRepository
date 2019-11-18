package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 游正荣
 * @create 2019-11-13 10:16
 */
@SpringBootApplication
@EnableEurekaServer// EurekaServer服务器端启动类,接受其它微服务注册进来
public class Config_Git_EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
    }
}

