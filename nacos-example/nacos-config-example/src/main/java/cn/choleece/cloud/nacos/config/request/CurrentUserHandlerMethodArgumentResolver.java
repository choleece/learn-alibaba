package cn.choleece.cloud.nacos.config.request;

import cn.choleece.cloud.nacos.config.annotation.CurrentUser;
import cn.choleece.cloud.nacos.config.modal.SysUser;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:36
 **/
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {

        System.out.println("谁先谁后呢,,,");
        SysUser sysUser = new SysUser();
        sysUser.setId("1");
        sysUser.setUserName("choleece");
        return sysUser;
    }
}
