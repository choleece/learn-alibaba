package cn.choleece.cloud.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 12:04
 **/
@SpringBootApplication
@RefreshScope
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }
}
