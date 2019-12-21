package cn.choleece.cloud.nacos.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 12:11
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "500";
    }
}
