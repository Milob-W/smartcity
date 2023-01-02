package com.briup.smartcity80.service.impl.ext;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.dao.basic.BaseUserMapper;
import com.briup.smartcity80.dao.ext.BaseUserExtMapper;
import com.briup.smartcity80.enums.BusinessErrorEnum;
import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.service.concrete.ext.IBaseUserExtService;
import com.briup.smartcity80.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 6:51 PM
 */
@Service
@Slf4j
public class BaseUserExtServiceImpl implements IBaseUserExtService {

    private final BaseUserMapper mapper;
    private final BaseUserExtMapper extMapper;

    public BaseUserExtServiceImpl(BaseUserMapper mapper, BaseUserExtMapper extMapper) {
        this.mapper = mapper;
        this.extMapper = extMapper;
    }

    @Override
    public String login(String username, String password) {

        log.info("用户尝试登录: username: {}, password: {}", username, password);

        BaseUser byUsername = extMapper.selectByUsername(username);

        if (byUsername == null) {
            log.warn("用户 {} 不存在", username);
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }

        Integer status = byUsername.getStatus();
        if (status != null || status != 0) {
            throw new BusinessException(BusinessErrorEnum.USER_LOCKED);
        }

        if (password == null || ! password.equals(password)) {
            throw new BusinessException(BusinessErrorEnum.LOGIN_PASSWORD_ERROR);
        }

        HashMap<String, Object> info = new HashMap<>();
        info.put("role", 1);

        String token = JwtUtils.sign(byUsername.getUserId().toString(), info);

        return token;
    }

    @Override
    public BaseUser currentUserInfo(String token) {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public void register(BaseUser user) {

    }
}
