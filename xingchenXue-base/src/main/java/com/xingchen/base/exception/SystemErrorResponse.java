package com.xingchen.base.exception;

import java.io.Serializable;

/**
 * @author: 35238
 * 功能: 统一异常处理的响应封装
 * 时间: 2024-04-04 16:15
 */
public class SystemErrorResponse implements Serializable {
    private String errMessage;

    public SystemErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}