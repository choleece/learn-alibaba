package cn.choleece.cloud.nacos.config.annotation;

import java.lang.annotation.*;

/**
 * @author choleece
 * @Description: 注解此注解的方法的返回内容，需要脱敏
 * @Date 2019-12-21 15:12
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface DesensitizeSupport {
}
