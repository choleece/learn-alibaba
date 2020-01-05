package cn.choleece.cloud.nacos.config.annotation;

import java.lang.annotation.*;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:35
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default "user";
}
