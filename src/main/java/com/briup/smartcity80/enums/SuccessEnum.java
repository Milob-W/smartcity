package com.briup.smartcity80.enums;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:39 PM
 */
public enum  SuccessEnum {

    OK(2000, "操作成功");

    private Integer code;
    private String msg;

    SuccessEnum(Integer code, String msg) {
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
