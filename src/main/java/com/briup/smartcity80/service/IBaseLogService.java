package com.briup.smartcity80.service;

import com.briup.smartcity80.bean.basic.BaseLog;
import com.github.pagehelper.PageInfo;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 3:39 PM
 */
public interface IBaseLogService {

    PageInfo<BaseLog> pageQuery(int pageNum, int pageSize);

    void addBaseLog(BaseLog log);

}
