package com.briup.smartcity80.service.impl;

import com.briup.smartcity80.bean.basic.Carousel;
import com.briup.smartcity80.dao.basic.CarouselMapper;
import com.briup.smartcity80.dao.ext.CarouselExtMapper;
import com.briup.smartcity80.exception.ServiceException;
import com.briup.smartcity80.service.ICarouselService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lining
 * @Date 2022/12/31
 */
@Service
public class CarouselServiceImpl implements ICarouselService {

    private final CarouselMapper mapper;
    private final CarouselExtMapper extMapper;

    public CarouselServiceImpl(CarouselMapper mapper, CarouselExtMapper extMapper) {
        this.mapper = mapper;
        this.extMapper = extMapper;
    }

    public PageInfo<Carousel> findAll(int pageNum, int pageSize) {
        //mapper.selectByPrimaryKey(1);
        //extMapper.xxx()
        return null;
    }

    public void deleteById(int id) throws ServiceException {
    }

    public void saveCarousel(Carousel carousel) {
        carousel.setCarouselStatus(ICarouselService.AVAILABLE);

        mapper.insert(carousel);
    }

    public void updateCarousel(Carousel carousel) {
        // 只修改非空的传递值
        mapper.updateByPrimaryKeySelective(carousel);
    }

    public List<Carousel> findYesCarousel() {
        return extMapper.selectByYes();
    }
}
