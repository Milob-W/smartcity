package com.briup.smartcity80.dao.basic;

import com.briup.smartcity80.bean.basic.BaseUser;
/*
*  这个接口是自动生成的，开发者不能手动修改该文件，
*  如果你修改文件内容，重新的逆向工程操作时，被覆盖重写。
* 开发者代码丢失。我们一般写在ext包下作为对基本单表操作的补充：
*   1.多表查询
*   2.非主键查询
*
* */
public interface BaseUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(BaseUser record);

    int insertSelective(BaseUser record); //动态sql 当提供的值不为null ，进行插入

    BaseUser selectByPrimaryKey(Integer userId);  //根据id查询信息

    int updateByPrimaryKeySelective(BaseUser record); //动态sql 当提供的值不为null ，进行更新

    int updateByPrimaryKey(BaseUser record);
}