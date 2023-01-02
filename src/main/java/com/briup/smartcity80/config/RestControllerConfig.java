package com.briup.smartcity80.config;

import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.result.JsonResult;
import com.briup.smartcity80.utils.CustomString;
import com.briup.smartcity80.utils.JsonResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;

/** controller 统一返回格式 和 统一异常处理
 * @Author congee(congee02@163.com)
 * @Date 1/2/2023 7:51 PM
 */
@RestControllerAdvice(basePackages = {"com.briup.smartcity80.web"})
@Slf4j
public class RestControllerConfig implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(BusinessException.class)
    public JsonResult businessException(BusinessException e) {
        return JsonResultUtils.error(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public JsonResult runtimeException(RuntimeException e) {
        e.printStackTrace();
        return JsonResultUtils.error(e);
    }

    @ExceptionHandler(Exception.class)
    public JsonResult exception(Exception e) {
        e.printStackTrace();
        return JsonResultUtils.error(e);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof CustomString) {
            return JsonResultUtils.ok((CustomString)body);
        }
        if (body == null) {
            return JsonResultUtils.ok();
        }
        if (body instanceof JsonResult) {
            return body;
        }
        return JsonResultUtils.ok(body);
    }
}
