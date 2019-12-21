package cn.choleece.cloud.nacos.config.annotation;

import java.lang.annotation.*;

/**
 * @author choleece
 * @Description: api 版本
 * @Date 2019-12-21 16:24
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {

    /**
     * 版本号从1开始
     * @return
     */
    int value() default 1;
}
