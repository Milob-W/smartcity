package com.briup.smartcity80.result;

import com.briup.smartcity80.enums.InternalErrorEnum;
import com.briup.smartcity80.enums.SuccessEnum;
import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.utils.CustomString;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:30 PM
 */
public class JsonResult {

    private static String dataMessage;

    private int code;
    private Object data;
    private String message;

    public JsonResult(CustomString customString) {
        this.code = SuccessEnum.OK.getCode();
        this.data = customString.getData();
        this.message = SuccessEnum.OK.getMsg();
    }

    public JsonResult(Object data) {
        this.code = SuccessEnum.OK.getCode();
        this.data = data;
        this.message = SuccessEnum.OK.getMsg();
    }

    public JsonResult(Object data, String msg) {
        this.code = SuccessEnum.OK.getCode();
        this.data = data;
        this.message = msg;
    }

    public JsonResult(Exception e) {
        this.code = InternalErrorEnum.INTERNAL_ERROR.getCode();
        this.data = null;
        this.message = InternalErrorEnum.INTERNAL_ERROR.getMsg();
    }

    public JsonResult(RuntimeException e) {
        this.data = null;
        this.code = InternalErrorEnum.INTERNAL_ERROR.getCode();
        this.message = InternalErrorEnum.INTERNAL_ERROR.getMsg();
    }

    public JsonResult(BusinessException be) {
        this.code = be.getCode();
        this.message = be.getMessage();
        return;
    }

    public JsonResult() {
        this.code = SuccessEnum.OK.getCode();
        this.data = dataMessage;
        this.message = SuccessEnum.OK.getMsg();
    }

    public static void setDataMessage(String dataMessage) {
        JsonResult.dataMessage = dataMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
