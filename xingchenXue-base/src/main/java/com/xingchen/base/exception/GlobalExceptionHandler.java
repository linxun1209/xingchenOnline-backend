package com.xingchen.base.exception;

import com.xingchen.base.enums.SystemExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: 35238
 * 功能: 全局异常处理器
 * 时间: 2024-04-04 16:18
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SystemErrorResponse customException(SystemException e) {
        log.error("【系统异常】{}",e.getErrMessage(),e);
        return new SystemErrorResponse(e.getErrMessage());

    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SystemErrorResponse exception(Exception e) {

        log.error("【系统异常】{}",e.getMessage(),e);

        return new SystemErrorResponse(SystemExceptionEnum.UNKOWN_ERROR.getErrMessage());
    }

    //字段检验出错时，返回给前端具体的message，这个message是你在实体类字段的@Size、@NotEmpty注解的message属性值
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<SystemErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = fieldError.getDefaultMessage();
        SystemErrorResponse response = new SystemErrorResponse(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}