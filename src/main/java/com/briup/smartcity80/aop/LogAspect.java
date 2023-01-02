package com.briup.smartcity80.aop;

import com.briup.smartcity80.bean.basic.BaseLog;
import com.briup.smartcity80.consts.api.BusinessApiConsts;
import com.briup.smartcity80.enums.BusinessErrorEnum;
import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @Author congee(congee02@163.com)
 * @Date 1/2/2023 9:06 PM
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.briup.smartcity80.service.*.*.*.*(..))")
    public void logPointcut() {
    }


    @Before("logPointcut()")
    public void beforeAdvice() {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        log.info("{} 开始记录日志信息", Thread.currentThread().getName());

        String uri = request.getRequestURI();
        log.info("uri: {}", uri);
        if (BusinessApiConsts.LOGIN.equals(uri) || BusinessApiConsts.REGISTER.equals(uri)) {
            return;
        }
        String token = request.getHeader("Authorization");
        if (token == null || token.length() < 1) {
            throw new BusinessException(BusinessErrorEnum.INVALID_LOGIN_CREDENTIAL);
        }
        String method = request.getMethod();

        Map<String, Object> info = JwtUtils.getInfo(token);
        String username = info.get("username").toString();
        String realname = info.get("realname").toString();

        BaseLog baseLog = new BaseLog();
        baseLog.setLogId(null);
        baseLog.setLogUsername(username);
        baseLog.setLogRealname(realname);
        baseLog.setLogRequestMethod(method);
        baseLog.setLogRequestUri(uri);
        baseLog.setLogTime(new Date());

        //TODO 录入数据库

        log.info("日志 {} 已录入数据库", baseLog.toString());

    }

    // 特殊处理 login 无 token 的日志记录
    @AfterReturning
            (pointcut = "execution(* com.briup.smartcity80.service.concrete.ext.IBaseUserExtService.login(..))",
                    returning = "token")
    public void loginLog(String token) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        Map<String, Object> info = JwtUtils.getInfo(token);
        String username = info.get("username").toString();
        String realname = info.get("realname").toString();

        BaseLog baseLog = new BaseLog();
        baseLog.setLogId(null);
        baseLog.setLogUsername(username);
        baseLog.setLogRealname(realname);
        baseLog.setLogRequestMethod(method);
        baseLog.setLogRequestUri(uri);
        baseLog.setLogTime(new Date());

        //TODO 录入数据库

        log.info("日志 {} 已录入数据库", baseLog.toString());

    }

}
