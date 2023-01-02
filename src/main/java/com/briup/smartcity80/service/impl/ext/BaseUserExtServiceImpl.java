package com.briup.smartcity80.service.impl.ext;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.dao.basic.BaseUserMapper;
import com.briup.smartcity80.dao.ext.BaseUserExtMapper;
import com.briup.smartcity80.enums.BusinessErrorEnum;
import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.service.base.ext.IBaseUserExtService;
import com.briup.smartcity80.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** 用户的业务操作实现
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

    /** 登录业务
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @Override
    public String login(String username, String password) {

        log.info("用户尝试登录: username: {}, password: {}", username, password);

        /* 根据用户名查询 */
        BaseUser byUsername = extMapper.selectByUsername(username);

        /* 判断用户是否存在 */
        if (byUsername == null) {
            log.warn("用户 {} 不存在", username);
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }

        /* 判断用户状态是否被锁定 */
        Integer status = byUsername.getStatus();
        if (status == null || status != 0) {
            throw new BusinessException(BusinessErrorEnum.USER_LOCKED);
        }

        /* 判断密码是否正确 */
        if (password == null || ! password.equals(byUsername.getPassword())) {
            throw new BusinessException(BusinessErrorEnum.LOGIN_PASSWORD_ERROR);
        }

        /* 要存放在 token 中的信息 */
        HashMap<String, Object> info = new HashMap<>();
        info.put("username", username);
        info.put("realname", byUsername.getRealname());

        /* 将信息封装并签名为 token */
        String token = JwtUtils.sign(byUsername.getUserId().toString(), info);

        return token;
    }

    /** 查看当前用户信息
     * @param token 用户token
     * @return  当前用户信息
     */
    @Override
    public BaseUser currentUserInfo(String token) {

        /* 校验token */
        if (! JwtUtils.checkSign(token)) {
            throw new BusinessException(BusinessErrorEnum.DATA_ERROR);
        }

        /* 从 map 中取出 username, 根据 username 找出记录返回 */
        Map<String, Object> info = JwtUtils.getInfo(token);
        String username = info.get("username").toString();
        BaseUser byUsername = extMapper.selectByUsername(username);

        /* 判空 */
        if (byUsername == null) {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }
        return byUsername;
    }

    /**
     * 登出
     */
    @Override
    public void logout() {
        log.info("登出");
    }

    /** 注册一个用户
     * @param user 注册所需用户信息
     */
    @Override
    public void register(BaseUser user) {

        /* 每个用户的手机号、邮箱、用户名不允许相同 */
        BaseUser byTelephone = extMapper.selectByTelephone(user.getTelephone());
        if (byTelephone != null) {
            throw new BusinessException("该手机号已被其他账户使用", BusinessErrorEnum.DUPLICATE_TELEPHONE);
        }
        BaseUser byEmail = extMapper.selectByEmail(user.getEmail());
        if (byEmail != null) {
            throw new BusinessException("该邮箱已被其他账户使用", BusinessErrorEnum.DUPLICATE_EMAIL);
        }
        BaseUser byUsername = extMapper.selectByUsername(user.getUsername());
        if (byUsername != null) {
            throw new BusinessException("该用户名已被其他账户使用", BusinessErrorEnum.DUPLICATE_USERNAME);
        }
        int updateNum = mapper.insertSelective(user);
        if (updateNum != 1) throw new RuntimeException("数据库插入错误");
    }
}
