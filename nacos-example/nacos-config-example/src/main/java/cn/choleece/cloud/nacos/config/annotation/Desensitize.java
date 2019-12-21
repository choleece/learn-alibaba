package cn.choleece.cloud.nacos.config.annotation;

import java.lang.annotation.*;

/**
 * @author choleece
 * @Description: 注解该注解的属性，需要脱敏
 * @Date 2019-12-21 15:21
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Documented
public @interface Desensitize {
    DesensitizeType value() default DesensitizeType.DEFAULT;
}
