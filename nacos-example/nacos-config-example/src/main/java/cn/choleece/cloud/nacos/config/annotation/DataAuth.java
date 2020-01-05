package cn.choleece.cloud.nacos.config.annotation;

import java.lang.annotation.*;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:00
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataAuth {

    /**
     * 数据鉴权方法名
     * @return
     */
    String validateMethodName() default "";

    /**
     * 鉴权bean的类
     * @return
     */
    Class validateBeanClass() default Object.class;

    /**
     * 验证的bean的名称
     * @return
     */
    String validateBeanName() default "";
}
