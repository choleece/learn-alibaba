package cn.choleece.cloud.nacos.config.controller;

import cn.choleece.cloud.nacos.config.annotation.DesensitizeSupport;
import cn.choleece.cloud.nacos.config.util.R;
import cn.choleece.cloud.nacos.config.vo.ResponseVo;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 12:07
 **/
@RestController
public class ConfigController {
    @NacosInjected
    private ConfigService configService;

    private static final Long GET_NACOS_CONFIG_TIMEOUT = 100000L;

    @Value("${user.name:chaoli}")
    private String userName;

    @GetMapping("/nacos/config")
    public String getConfig(String dataId, String group) throws NacosException {
        return configService.getConfig(dataId, group, GET_NACOS_CONFIG_TIMEOUT);
    }

    @GetMapping("/user/name")
    public String getUserName() {
        System.out.println("get user name: " + userName);
        return userName;
    }

    @DesensitizeSupport
    @GetMapping("/vo/data")
    public R getVoData() {
        ResponseVo vo = new ResponseVo();
        vo.setAddress("湖北省孝感市人民广场1号");
        vo.setName("郑超力");
        vo.setEmail("choleece@163.com");
        vo.setMobile("18202802615");
        return R.ok(vo);
    }
}
