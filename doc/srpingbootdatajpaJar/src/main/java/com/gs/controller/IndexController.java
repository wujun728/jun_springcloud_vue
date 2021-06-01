package com.gs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: srpingbootdatajpa
 * @Package: com.gs.controller
 * @Description: java类作用描述
 * @Author: Administrator
 * @CreateDate: 2018/4/27 9:40
 * @UpdateUser: Administrator
 * @UpdateDate: 2018/4/27 9:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index1(){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("text", "hello jsp");
        model.put("list", Arrays.asList(1, 2, 3, 4, 5));
        return new ModelAndView("index",model);
    }

    @RequestMapping(value = "/login")
    public String login1(){

        return "login";
    }


}
