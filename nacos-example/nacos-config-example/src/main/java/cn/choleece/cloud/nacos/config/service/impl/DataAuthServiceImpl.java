package cn.choleece.cloud.nacos.config.service.impl;

import cn.choleece.cloud.nacos.config.modal.SysUser;
import cn.choleece.cloud.nacos.config.service.IDataAuthService;
import org.springframework.stereotype.Service;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 16:51
 **/
@Service("dataAuthService")
public class DataAuthServiceImpl implements IDataAuthService {

    @Override
    public Boolean hasPermissionOptRole(String id, SysUser sysUser) {

        System.out.println("我来鉴权了...");

        return "1".equals(id);
    }
}
