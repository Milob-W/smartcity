package com.briup.smartcity80.service.base.basic;

import com.github.pagehelper.PageInfo;

/** 分页查询接口
 * @Author congee(congee02 @ 163.com)
 * @Date 1/3/2023 12:45 AM
 */
public interface IPageInfoService<T> {

    PageInfo<T> selectByPage(int pageNum, int pageSize);

}
