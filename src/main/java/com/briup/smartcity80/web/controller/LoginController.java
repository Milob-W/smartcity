package com.briup.smartcity80.web.controller;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.service.IBaseUserService;
import com.briup.smartcity80.util.Result;
import com.briup.smartcity80.util.ResultUtil;
import com.briup.smartcity80.web.vo.RegisterBaseUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录相关模块
 * @Author lining
 * @Date 2022/12/31
 */
@Api(tags = "登录相关模块")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private IBaseUserService service;


   @ApiOperation("用户登录")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "username",value = "用户名",required = true),
           @ApiImplicitParam(name = "password",value = "密码",required = true)
   })
   @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
   public Result login(String username,String password){//BaseUser user

       String token = service.login(username, password);
       return ResultUtil.success(token);
   }

   @PostMapping("reg")
    public Result register(RegisterBaseUserVO vo) {
       BaseUser user = new BaseUser();
       BeanUtils.copyProperties(vo, user);
       service.addUser(user);
       return ResultUtil.success(user);
    }

}
