package com.briup.smartcity80.utils;

import lombok.Data;

/** RestController 不允许直接返回 String
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 11:03 PM
 */
public class CustomString {

    private String data;

    public CustomString(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
