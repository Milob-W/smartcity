package com.briup.smartcity80.web.controller.concrete;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.consts.MessageConsts;
import com.briup.smartcity80.consts.api.BusinessApiConsts;
import com.briup.smartcity80.result.JsonResult;
import com.briup.smartcity80.service.base.ext.IBaseUserExtService;
import com.briup.smartcity80.utils.CustomString;
import com.briup.smartcity80.web.vo.BaseUserRegisterVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 10:30 PM
 */
@RestController
@RequestMapping
@Slf4j
public class BaseUserExtController {

    private final IBaseUserExtService baseUserExtService;

    public BaseUserExtController(IBaseUserExtService baseUserExtService) {
        this.baseUserExtService = baseUserExtService;
    }

    @PostMapping(value = BusinessApiConsts.LOGIN, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public CustomString login(String username, String password) {
        String token = baseUserExtService.login(username, password);
        return new CustomString(token);
    }

    @PostMapping(value = BusinessApiConsts.REGISTER, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void register(BaseUserRegisterVO vo) {
        BaseUser baseUser = new BaseUser();
        BeanUtils.copyProperties(vo, baseUser);
        log.info("baseUser: {}", baseUser);
        JsonResult.setDataMessage(MessageConsts.REGISTER_SUCCESS);
        baseUserExtService.register(baseUser);
    }

    @GetMapping(value = BusinessApiConsts.LOGOUT)
    public void logout() {
        baseUserExtService.logout();
    }

    @GetMapping(value = BusinessApiConsts.CURRENT_USER_INFO)
    public BaseUser currentBaseUserInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return baseUserExtService.currentUserInfo(token);
    }

}
