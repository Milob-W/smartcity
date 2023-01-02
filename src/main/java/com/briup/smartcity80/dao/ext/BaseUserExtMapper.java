package com.briup.smartcity80.dao.ext;

import com.briup.smartcity80.bean.basic.BaseUser;

/**
 * 实现自定义的对用户信息的数据库操作
 * @Author lining
 * @Date 2022/12/31
 */
public interface BaseUserExtMapper {
    //根据业务需求，编写方法
    BaseUser selectByUsername(String name);
    BaseUser selectByTelephone(String tel);
    BaseUser selectByEmail(String email);
}
