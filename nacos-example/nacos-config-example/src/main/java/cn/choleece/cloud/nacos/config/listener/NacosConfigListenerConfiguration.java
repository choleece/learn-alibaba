package cn.choleece.cloud.nacos.config.listener;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 14:42
 **/
@Configuration
public class NacosConfigListenerConfiguration {

    @NacosConfigListener(dataId = "nacos-config-example")
    public void onMessage(String config) {
        System.out.println("changed config: " + config);
    }
}
