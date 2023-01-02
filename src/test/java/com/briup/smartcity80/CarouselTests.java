package com.briup.smartcity80;

import com.briup.smartcity80.dao.ext.CarouselExtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 11:22 AM
 */
@SpringBootTest
public class CarouselTests {

    @Autowired
    private CarouselExtMapper extMapper;

    @Test
    public void addCarouselTest() {
        System.out.println(extMapper.selectByCarouselUrl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2414248643,505632809&fm=26&gp=0.jpg"));
    }

    @Test
    public void selectCarouselByUrl() {
        System.out.println(extMapper.selectByYes());
    }

}
