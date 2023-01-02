package com.briup.smartcity80.exception;

import com.briup.smartcity80.util.ResultEnum;

/**
 * @Author lining
 * @Date 2022/12/31
 */
public class ServiceException extends RuntimeException{

    private Integer code;

    public ServiceException(ResultEnum resultEnum, String message) {
        super(message);
        this.code = resultEnum.getCode();
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
