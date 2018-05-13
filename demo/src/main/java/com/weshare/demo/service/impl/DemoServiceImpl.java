package com.weshare.demo.service.impl;

import com.weshare.demo.dao.DemoDao;
import com.weshare.demo.model.Demo;
import com.weshare.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;
    @Override
    public List<Demo> list() {
        return demoDao.list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=3600,rollbackFor=Exception.class)
    public void addDemo(Demo demo) throws Exception {
        demoDao.addDemo(demo);
        throw new Exception("事物测试");
    }
}
