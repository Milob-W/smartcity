package com.briup.smartcity80.web.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/** web层中传递注册信息的类
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 11:30 PM
 */
@Data
public class BaseUserRegisterVO {

    private String username;

    private String password;

    private String telephone;

    private String realname;

    private String icon;

    private Integer gender;

    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private Date dob;

    private String email;

}
