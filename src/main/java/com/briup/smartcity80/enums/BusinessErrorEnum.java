package com.briup.smartcity80.enums;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:33 PM
 */
public enum BusinessErrorEnum {

    LOGIN_PASSWORD_ERROR(10001,"密码错误"),
    DUPLICATE_TELEPHONE(10002, "此手机号已被注册"),
    USER_NOT_FOUND(10004, "用户不存在"),
    USER_LOCKED(10003, "账号被锁定，请联系账户管理员"),
    DUPLICATE_EMAIL(10005, "此邮箱已被注册"),
    DUPLICATE_USERNAME(10002, "此用户名已被注册"),

    DATA_ERROR(20001,"数据错误");

    private Integer code;
    private String msg;

    BusinessErrorEnum(Integer code, String msg) {
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
