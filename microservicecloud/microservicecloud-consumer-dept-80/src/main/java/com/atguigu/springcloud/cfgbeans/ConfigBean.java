package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zryou
 * @create 2019-11-12 22:54
 * @Description
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现都一套客户端 负载均衡的工具
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
