package com.atguigu.springcloud.cfgbeans;

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
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
