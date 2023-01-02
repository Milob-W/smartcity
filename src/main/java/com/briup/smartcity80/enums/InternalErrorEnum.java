package com.briup.smartcity80.enums;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:42 PM
 */
public enum InternalErrorEnum {

    INTERNAL_ERROR(5000, "内部错误，请联系系统管理员");

    private Integer code;
    private String msg;

    InternalErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
