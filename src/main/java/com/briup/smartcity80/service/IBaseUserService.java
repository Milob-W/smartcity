package com.briup.smartcity80.service;

import com.briup.smartcity80.bean.basic.BaseUser;

/**
 * 用户信息业务接口
 * @Author lining
 * @Date 2022/12/31
 */
public interface IBaseUserService {
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

    void addUser(BaseUser user);


}
