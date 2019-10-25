package com.cloud.zhpt.exception;

import com.cloud.zhpt.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExceptionHandler
 * @Description 全局异常处理器
 * @Author SW
 * @Date 2019/10/17 10:35
 **/
@RestControllerAdvice
public class CommonExceptionHandler {

    protected final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(CustomRunTimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleCustomException(CustomRunTimeException ex) {
        logger.info("CustomRunTimeException: " + HttpStatus.INTERNAL_SERVER_ERROR , ex);
        Map<String, Object> errorResultMap = new HashMap<>(16);
        errorResultMap.put("code", ex.getCode());
        errorResultMap.put("message", ex.getMessage());
        return errorResultMap;
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public HttpResult unknownException(Exception ex) {
        logger.info("unknownException:" + HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return new HttpResult(HttpResult.FAILED, ex.getMessage());
    }


}
