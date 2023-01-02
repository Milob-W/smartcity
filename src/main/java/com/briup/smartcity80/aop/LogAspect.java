package com.briup.smartcity80.aop;

import com.briup.smartcity80.dao.basic.BaseLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 3:14 PM
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    private BaseLogMapper mapper;

    @Pointcut("execution(* com.briup.smartcity80.service.*.*(..))")
    public void loginPointCut() {

    }


    @Before("loginPointCut()")
    public void beforeAdvice() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) attributes;
        HttpServletRequest request = sra.getRequest();

        log.info("method: {}", request.getMethod());
        log.info("uri: {}", request.getRequestURI());
        log.info("token: {}", request.getHeader("Authorization"));

//        request.getParameter()

        // TODO: 1/2/2023 解析 JWT 字符串，获取 username, realname (from userMapInfo)
        // TODO: 1/2/2032   用户第一次登录不提供 token，但仍需j记录登录日志，如何实现？


        
    }

}
