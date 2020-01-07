package cn.choleece.cloud.nacos.config.controller;

import cn.choleece.cloud.nacos.config.annotation.CurrentUser;
import cn.choleece.cloud.nacos.config.annotation.DataAuth;
import cn.choleece.cloud.nacos.config.modal.SysUser;
import cn.choleece.cloud.nacos.config.service.IDataAuthService;
import org.springframework.web.bind.annotation.*;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:01
 **/
@RestController("dataAuthController")
@RequestMapping("/data")
public class DataAuthController {

    @GetMapping("/detail")
    @DataAuth(validateMethodName = "hasPermissionOptRole", validateBeanClass = IDataAuthService.class, validateBeanName = "dataAuthService")
    public String getDataDetail(String id, @CurrentUser SysUser sysUser) {

        System.out.println(sysUser.toString());
        System.out.println("id: " + id);
        return id;
    }

    @PostMapping("/user")
    public String addUser(@RequestBody SysUser sysUser) {
        return sysUser.toString();
    }
}
