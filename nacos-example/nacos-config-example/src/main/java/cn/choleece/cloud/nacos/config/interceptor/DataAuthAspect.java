package cn.choleece.cloud.nacos.config.interceptor;

import cn.choleece.cloud.nacos.config.annotation.DataAuth;
import cn.choleece.cloud.nacos.config.exception.SysException;
import cn.choleece.cloud.nacos.config.service.IDataAuthService;
import cn.choleece.cloud.nacos.config.util.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author choleece
 * @Description: 数据权限鉴权
 * @Date 2020-01-05 15:16
 **/
@Aspect
@Component
public class DataAuthAspect {

    /**
     * data auth interceptor
     */
    @Pointcut("@annotation(cn.choleece.cloud.nacos.config.annotation.DataAuth)")
    public void dataAuthInterceptor() {
    }

    @Before("dataAuthInterceptor()")
    public void interceptTccMethod(final JoinPoint joinPoint) throws Throwable {
        Boolean validateResult = null;
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Object[] args = joinPoint.getArgs();

            final DataAuth dataAuth = method.getAnnotation(DataAuth.class);

            if (dataAuth != null) {
                String validateMethodName = dataAuth.validateMethodName();
                String validateBeanName = dataAuth.validateBeanName();
                Class validateBeanClass = dataAuth.validateBeanClass();

                Object validateBean = null;

                if (validateBeanClass != null && !(Object.class.equals(validateBeanClass))) {
                    validateBean = SpringContextUtils.getBean(validateBeanClass);
                }

                if (validateBean == null && !StringUtils.isEmpty(validateBeanName)) {
                    validateBean = SpringContextUtils.getBean(validateBeanName);
                }

                Method validateMethod = null;
                if (validateBean != null && !StringUtils.isEmpty(validateMethodName)
                        && (validateMethod = validateBean.getClass().getMethod(validateMethodName, method.getParameterTypes())) != null) {
                    validateResult  = (Boolean) validateMethod.invoke(validateBean, args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // do nothing when exception happened...
        } finally {
            if (validateResult != null && !validateResult) {
                throw new SysException("没得权限操作...");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(IDataAuthService.class.equals(Object.class));
    }
}
