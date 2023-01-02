package com.briup.smartcity80.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * @Author lining
 * @Date 2022/12/31
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*补充拦截器代码*/

        return true;
    }
}
