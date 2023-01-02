package com.briup.smartcity80.service.base.basic;


/** 声明增删改查改查的父接口，业务 (manage)
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 6:37 PM
 */
public interface ICRUDService<T> {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(T record);

    T  selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

}
