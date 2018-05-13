package com.weshare.demo.common.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
//指定扫描的mapper接口所在的包
@MapperScan("com.weshare.demo.dao")
public class AppMybatisConfiguration {
}
