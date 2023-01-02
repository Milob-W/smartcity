package com.briup.smartcity80.service.base.ext;

import com.briup.smartcity80.bean.basic.BaseUser;

/** 用户的业务操作
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 6:46 PM
 */
public interface IBaseUserExtService {

    /**
     *  用户登录接口,返回token字符串
     * @param username 用户名
     * @param password 密码
     * @return jwt字符串
     */
    String login(String username,String password);


    /** 通过token获取当前登录用户的信息
     * @param token
     * @return 用户对象
     */
    BaseUser currentUserInfo(String token);

    void logout();

    /** 注册一个用户
     * @param user 注册用户信息
     */
    void register(BaseUser user);

}
