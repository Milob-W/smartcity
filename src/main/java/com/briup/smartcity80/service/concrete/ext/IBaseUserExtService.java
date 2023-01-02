package com.briup.smartcity80.service.concrete.ext;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.service.base.ext.IExtService;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 6:46 PM
 */
public interface IBaseUserExtService extends IExtService<BaseUser> {

    /**
     *  用户登录接口,返回token字符串
     * @param username 用户名
     * @param password 密码
     * @return jwt字符串
     */
    String login(String username,String password);

    //通过token获取当前登录用户的信息
    BaseUser currentUserInfo(String token);

    void logout();

    void register(BaseUser user);

}
