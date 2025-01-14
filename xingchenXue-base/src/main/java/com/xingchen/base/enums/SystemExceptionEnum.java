package com.xingchen.base.enums;

/**
 * @author: 35238
 * 功能: 统一异常处理的枚举类
 * 时间: 2024-04-04 16:08
 */
public enum SystemExceptionEnum {
    
    UNKOWN_ERROR("执行过程异常，请重试。"),
    PARAMS_ERROR("非法参数"),
    OBJECT_NULL("对象为空"),
    QUERY_NULL("查询结果为空"),
    REQUEST_NULL("请求参数为空");

    private String errMessage;

    public String getErrMessage() {
        return errMessage;
    }

    private SystemExceptionEnum( String errMessage) {
        this.errMessage = errMessage;
    }
    
}