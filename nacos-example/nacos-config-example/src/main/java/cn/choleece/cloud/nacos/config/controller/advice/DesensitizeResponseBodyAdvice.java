package cn.choleece.cloud.nacos.config.controller.advice;

import cn.choleece.cloud.nacos.config.annotation.Desensitize;
import cn.choleece.cloud.nacos.config.annotation.DesensitizeSupport;
import cn.choleece.cloud.nacos.config.annotation.DesensitizeType;
import cn.choleece.cloud.nacos.config.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 15:19
 **/
@RestControllerAdvice
public class DesensitizeResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        /**
         * 判断返回方法上是否包含desensitize support annotation, 如果包含，则需要走下边的方法
         */
        return methodParameter.getMethod().getAnnotation(DesensitizeSupport.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o == null) {
            return null;
        }

        if (o instanceof R) {
            R r = (R) o;
            Object data = null;
            if (r.getSuccess() && (data = r.getData()) != null) {
                Collection collection = null;
                if (data instanceof Collection) {
                    collection = (Collection) data;
                } else if (data.getClass().isArray()) {
                    if (data.getClass().getComponentType().isPrimitive()) {
                        return o;
                    }
                    collection = Arrays.asList(data);
                } else {
                    collection = Collections.singletonList(data);
                }

                collection.stream().forEach(obj -> {
                    Class clazz = obj.getClass();

                    Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getAnnotation(Desensitize.class) != null && String.class == field.getType())
                            .forEach(field -> {
                                DesensitizeType desensitizeType = field.getAnnotation(Desensitize.class).value();

                                // 获取原对象上的值
                                String oldValue = null;
                                try {
                                    field.setAccessible(true);
                                    oldValue = (String) field.get(obj);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                                if (!StringUtils.isEmpty(oldValue)) {
                                    String newValue = desensitizeValue(oldValue, desensitizeType);

                                    try {
                                        field.set(obj, newValue);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                });
            }
            return o;
        }
        return o;
    }

    private String desensitizeValue(String oldValue, DesensitizeType desensitizeType) {
        if (StringUtils.isEmpty(oldValue)) {
            return null;
        }

        switch (desensitizeType) {
            case NAME:
                return desensitizeName(oldValue);
            case EMAIL:
                return desensitizeEmail(oldValue);
            case MOBILE:
                return desensitizeMobile(oldValue);
            case ADDRESS:
                return desensitizeAddress(oldValue, 4);
            default:
                return null;
        }
    }

    private String desensitizeAddress(String oldValue, final int sensitiveSize) {
        if (StringUtils.isBlank(oldValue)) {
            return "";
        }
        final int length = StringUtils.length(oldValue);
        return StringUtils.rightPad(StringUtils.left(oldValue, length - sensitiveSize), length, "*");
    }

    private String desensitizeMobile(String oldValue) {
        if (StringUtils.isBlank(oldValue)) {
            return "";
        }
        return StringUtils.left(oldValue, 2).concat(StringUtils
                .removeStart(StringUtils.leftPad(StringUtils.right(oldValue, 2), StringUtils.length(oldValue), "*"),
                        "***"));
    }

    private String desensitizeEmail(String oldValue) {
        if (StringUtils.isBlank(oldValue)) {
            return StringUtils.EMPTY;
        }
        final int index = StringUtils.indexOf(oldValue, "@");
        
        if (index <= 1) {
            return oldValue;
        }
        return StringUtils.rightPad(StringUtils.left(oldValue, 1), index, "*")
                .concat(StringUtils.mid(oldValue, index, StringUtils.length(oldValue)));
    }

    private String desensitizeName(String oldValue) {
        if (StringUtils.isEmpty(oldValue)) {
            return StringUtils.EMPTY;
        }
        
        return StringUtils.rightPad(StringUtils.left(oldValue, 1), StringUtils.length(oldValue), "*");
    }
}
