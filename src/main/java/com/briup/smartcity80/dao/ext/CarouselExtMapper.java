package com.briup.smartcity80.dao.ext;

import com.briup.smartcity80.bean.basic.Carousel;

import java.util.List;

/**
 * 自定义的轮播图信息的数据库操作
 * @Author lining
 * @Date 2022/12/31
 */
public interface CarouselExtMapper {
    List<Carousel> selectByYes();
    Carousel selectByCarouselUrl(String url);
}
