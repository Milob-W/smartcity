package com.briup.smartcity80.exception;

import com.briup.smartcity80.enums.BusinessErrorEnum;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:31 PM
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(BusinessErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public BusinessException(String message, BusinessErrorEnum errorEnum) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
