package com.briup.smartcity80.service;

import com.briup.smartcity80.bean.basic.Carousel;
import com.briup.smartcity80.exception.ServiceException;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 轮播图业务接口
 * @Author lining
 * @Date 2022/12/31
 */
public interface ICarouselService {

    int AVAILABLE = 0;
    int LOCKED = 1;

    // 分页查询轮播图信息
    PageInfo<Carousel> findAll(int pageNum, int pageSize);
    // 通过id删除轮播图信息
    void deleteById(int id) throws ServiceException;
    // 保存轮播图信息
    void saveCarousel(Carousel carousel);
    // 更新轮播图信息
    void updateCarousel(Carousel carousel);
    // 查询所有已经启用的轮播图
    List<Carousel> findYesCarousel();
}
