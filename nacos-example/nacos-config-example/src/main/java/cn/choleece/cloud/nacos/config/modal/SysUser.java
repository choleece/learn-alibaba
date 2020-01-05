package cn.choleece.cloud.nacos.config.modal;

import lombok.Builder;
import lombok.Data;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:37
 **/
@Data
@Builder
public class SysUser {

    private String id;

    private String userName;
}
