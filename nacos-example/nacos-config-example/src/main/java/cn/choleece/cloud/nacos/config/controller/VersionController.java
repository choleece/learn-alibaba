package cn.choleece.cloud.nacos.config.controller;

import cn.choleece.cloud.nacos.config.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choleece
 * @Description: api 版本设置
 * @Date 2019-12-21 16:40
 **/
@RestController
@ApiVersion
@RequestMapping("/thor/api/{version}/test")
public class VersionController {

    @GetMapping
    public String versionOne(@PathVariable String version) {
        System.out.println("version one...");
        return "version: " + version;
    }

    @ApiVersion(2)
    @GetMapping()
    public String versionTwo(@PathVariable String version) {
        System.out.printf("version two");
        return "version: " + version;
    }
}
