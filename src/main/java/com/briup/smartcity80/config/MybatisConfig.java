package com.briup.smartcity80.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 指定mybatis映射器接口所在的位置
 * @Author lining
 * @Date 2022/12/31
 */
@Configuration
@MapperScan(basePackages = "com.briup.smartcity80.dao")
public class MybatisConfig {

}
