package com.weshare.demo.dao;

import com.weshare.demo.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoDao {
    @Select("SELECT * FROM demo")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name",  column = "name"),
            @Result(property = "number",  column = "number"),
            @Result(property = "insertTime",  column = "insert_time")
    })
    List<Demo> list();

    void addDemo(Demo demo);
}
