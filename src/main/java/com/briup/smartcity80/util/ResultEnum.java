package com.briup.smartcity80.util;

/**
 * 使用枚举类表示响应信息常用字符串和状态码
 * @Author lining
 * @Date 2022/12/26
 */
public enum ResultEnum {
    SUCCESS(1,"操作成功"),
    ERROR(2,"操作失败"),


    INTERNAL_ERROR(3, "系统内部错误，请联系系统管理员"),
    //login_passwd_error
    LOGIN_PASSWD_ERROR(10001,"密码错误"),
    DUPLICATE_TELEPHONE(10002, "此手机号已被注册"),
    USER_NOT_FOUND(10004, "用户不存在"),
    USER_LOCKED(10003, "账号被锁定，请联系账户管理员"),
    //数据错误
    DATA_ERROR(20001,"数据错误");

    //定义一个枚举对象表示具体的一个错误信息 用户不存在

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
