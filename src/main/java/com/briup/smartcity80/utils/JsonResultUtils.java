package com.briup.smartcity80.utils;

import com.briup.smartcity80.result.JsonResult;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:36 PM
 */
public final class JsonResultUtils {

    private JsonResultUtils() {
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok(Object data, String message) {
        return new JsonResult(data, message);
    }

    public static JsonResult error(Exception e) {
        return new JsonResult(e);
    }

    public static JsonResult error(RuntimeException e) {
        return new JsonResult(e);
    }

}
