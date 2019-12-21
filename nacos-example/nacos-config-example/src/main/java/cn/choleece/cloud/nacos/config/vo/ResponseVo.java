package cn.choleece.cloud.nacos.config.vo;

import cn.choleece.cloud.nacos.config.annotation.Desensitize;
import cn.choleece.cloud.nacos.config.annotation.DesensitizeType;
import lombok.Data;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 15:01
 **/
@Data
public class ResponseVo {

    @Desensitize(value = DesensitizeType.NAME)
    private String name;

    private String sex;

    @Desensitize(value = DesensitizeType.MOBILE)
    private String mobile;

    @Desensitize(value = DesensitizeType.ADDRESS)
    private String address;

    @Desensitize(value = DesensitizeType.EMAIL)
    private String email;
}
