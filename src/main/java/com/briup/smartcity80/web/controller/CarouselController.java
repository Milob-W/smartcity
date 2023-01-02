package com.briup.smartcity80.web.controller;

import com.briup.smartcity80.bean.basic.Carousel;
import com.briup.smartcity80.service.ICarouselService;
import com.briup.smartcity80.util.Result;
import com.briup.smartcity80.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 轮播图管理模块
 * web层：一定根据前端分离设计接口进行方法映射
 * @Author lining
 * @Date 2022/12/31
 */
@RequestMapping("/auth/carousel")
@Api(tags = "轮播图模块")
@RestController
public class CarouselController {
    @Autowired
    private ICarouselService service;

    @GetMapping("/yes")
    public Result findByYes(){
        List<Carousel> list = service.findYesCarousel();
        return ResultUtil.success(list);
    }

    @PostMapping
    public Result addCarousel(String carouselInfo, String carouselName, String carouselUrl) {
        Carousel carousel = Carousel.builder().carouselInfo(carouselInfo).carouselName(carouselName).carouselUrl(carouselUrl).build();
        service.saveCarousel(carousel);
        return ResultUtil.success();
    }
}
