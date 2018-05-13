package com.weshare.demo.service;

import com.weshare.demo.model.Demo;

import java.util.List;

public interface DemoService {
    List<Demo> list();

    void addDemo(Demo demo)throws Exception;
}
