package cn.choleece.learn.alibaba.nacos.discovery.consumer.config;

import cn.choleece.learn.alibaba.nacos.discovery.consumer.feign.EchoServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by choleece on 2019/4/20.
 */
@Configuration
public class InitialBean {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
