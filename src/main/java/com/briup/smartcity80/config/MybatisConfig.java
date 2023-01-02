package com.briup.smartcity80.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:27 PM
 */
@Configuration
@MapperScan(basePackages = "com.briup.smartcity80.dao")
public class MybatisConfig {

}
