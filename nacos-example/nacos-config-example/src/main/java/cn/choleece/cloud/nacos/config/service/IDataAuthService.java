package cn.choleece.cloud.nacos.config.service;

import cn.choleece.cloud.nacos.config.modal.SysUser;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 16:50
 **/
public interface IDataAuthService {

    /**
     * 判断是否有条件操作数据
     * @param id
     * @param sysUser
     * @return
     */
    Boolean hasPermissionOptRole(String id, SysUser sysUser);
}
