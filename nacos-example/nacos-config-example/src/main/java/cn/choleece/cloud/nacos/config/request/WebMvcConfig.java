package cn.choleece.cloud.nacos.config.request;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 16:39
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserHandlerMethodArgumentResolver());
    }
}