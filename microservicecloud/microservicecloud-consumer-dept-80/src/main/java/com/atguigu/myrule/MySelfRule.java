package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 游正荣
 * @create 2019-11-14 9:38
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return new RandomRule();  //默认轮询，自定义为随机
        return new RandomRule_YZR(); //自定义每台机器5次
    }
}
