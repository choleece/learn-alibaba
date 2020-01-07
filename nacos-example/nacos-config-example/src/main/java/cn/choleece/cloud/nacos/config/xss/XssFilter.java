package cn.choleece.cloud.nacos.config.xss;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-07 22:59
 **/
@EnableWebMvc
@Configuration
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest){
            HttpServletRequest hsr = (HttpServletRequest) request;
            String s = hsr.getRequestURL().toString().toUpperCase();
            //涉及保存操作的进行xss过滤
            boolean b = true;
            if (b) {
                request = new XssHttpServletRequestWrapper((HttpServletRequest) request);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
