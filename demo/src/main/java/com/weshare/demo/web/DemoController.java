package com.weshare.demo.web;

import com.github.pagehelper.PageHelper;
import com.weshare.demo.common.bean.ExceptionEnum;
import com.weshare.demo.common.bean.PageBean;
import com.weshare.demo.common.bean.Result;
import com.weshare.demo.common.exception.ExceptionHandle;
import com.weshare.demo.common.util.ResultUtil;
import com.weshare.demo.model.Demo;
import com.weshare.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {
    //增加日志
    private final Logger log = LoggerFactory.getLogger(DemoController.class);
    @Resource
    private DemoService demoService;
    @Autowired
    private ExceptionHandle exceptionHandle;
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/list/{currentPage}/{pageSize}")
    @ResponseBody
    public PageBean list(Model model, @PathVariable("currentPage") int currentPage,
                     @PathVariable("pageSize") int pageSize) {
        // 指定当前需要显示的页码（currentPage），页面列表长度（pageSize）
        PageHelper.startPage(currentPage, pageSize);
        PageBean page = new PageBean<Demo>(demoService.list());
        return page;
    }

    @RequestMapping("/list1/{currentPage}/{pageSize}")
    @ResponseBody
    public Map list1(Model model, @PathVariable("currentPage") int currentPage,
                     @PathVariable("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 指定当前需要显示的页码（currentPage），页面列表长度（pageSize）
        PageHelper.startPage(currentPage, pageSize);
        PageBean page = new PageBean<Demo>(demoService.list());
        map.put("page",page);
        return map;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Demo demo) {

        Result result = ResultUtil.success();
        try {
            demo.setInsertTime(new Date());
            demoService.addDemo(demo);
        }catch (Exception e){
            result =  exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    /**
     * 返回体测试
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/getResult",method = RequestMethod.POST)
    @ResponseBody
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        Result result = ResultUtil.success();
        try {
            if (name.equals("xmd")){
                result =  ResultUtil.success(new Demo());
            }else if (name.equals("pzz")){
                result =  ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
            }else{
                int i = 1/0;
            }
        }catch (Exception e){
            result =  exceptionHandle.exceptionGet(e);
        }
        return result;
    }

}
