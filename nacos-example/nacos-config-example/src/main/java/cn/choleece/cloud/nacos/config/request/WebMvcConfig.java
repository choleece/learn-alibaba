package cn.choleece.cloud.nacos.config.request;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

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
}