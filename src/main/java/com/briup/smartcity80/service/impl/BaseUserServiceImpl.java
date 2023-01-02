package com.briup.smartcity80.service.impl;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.dao.basic.BaseUserMapper;
import com.briup.smartcity80.dao.ext.BaseUserExtMapper;
import com.briup.smartcity80.exception.ServiceException;
import com.briup.smartcity80.service.IBaseUserService;
import com.briup.smartcity80.util.JwtUtil;
import com.briup.smartcity80.util.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author lining
 * @Date 2022/12/31
 */
@Slf4j
@Service //service对象
public class BaseUserServiceImpl implements IBaseUserService {
    @Autowired
    private BaseUserMapper mapper;//逆向工程生成的映射器对象 基本CURD
    @Autowired
    private BaseUserExtMapper extMapper;//扩展映射器 新增CURD

    @Override
    public String login(String username, String password) {
        log.info("用户尝试登录: username: {}, password: {}", username, password);

        BaseUser byUsername = extMapper.selectByUsername(username);

        if (byUsername == null) {
            log.warn("用户 {} 不存在", username);
            throw new ServiceException(ResultEnum.USER_NOT_FOUND);
        }

        Integer status = byUsername.getStatus();
        if (status != null || status != 0) {
            throw new ServiceException(ResultEnum.USER_LOCKED);
        }

        if (password == null || ! password.equals(password)) {
            throw new ServiceException(ResultEnum.LOGIN_PASSWD_ERROR);
        }

        HashMap<String, Object> info = new HashMap<>();
        info.put("role", 1);

        String token = JwtUtil.sign(byUsername.getUserId().toString(), info);

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
    public void addUser(BaseUser user) {
        String telephone = user.getTelephone();
        BaseUser byTelephone = extMapper.selectByTelephone(telephone);
        if (byTelephone != null) {
            throw new ServiceException(ResultEnum.DUPLICATE_TELEPHONE);
        }
        mapper.insert(user);
    }
}
