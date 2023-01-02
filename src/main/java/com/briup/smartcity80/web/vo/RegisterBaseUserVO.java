package com.briup.smartcity80.web.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 10:16 AM
 */
@Data
public class RegisterBaseUserVO {

    private String username;

    private String password;

    private String telephone;

    private String realname;

    private String icon;

    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String email;

}
