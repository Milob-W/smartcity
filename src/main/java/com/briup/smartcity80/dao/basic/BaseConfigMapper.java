package com.briup.smartcity80.dao.basic;

import com.briup.smartcity80.bean.basic.BaseConfig;

public interface BaseConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(BaseConfig record);

    int insertSelective(BaseConfig record);

    BaseConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(BaseConfig record);

    int updateByPrimaryKey(BaseConfig record);
}