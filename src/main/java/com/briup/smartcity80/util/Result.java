package com.briup.smartcity80.util;

/**
 * @Author lining
 * @Date 2022/12/26
 */
public class Result {
    private Integer status;
    private String message;
    private Object data;

    public Result() {

    }
    public Result(ResultEnum resultCode) {
        this.status = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
