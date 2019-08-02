package com.springcloud.demo.controller;

import com.springcloud.demo.bean.My;
import com.springcloud.demo.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yml")
public class YmlDemoController {

    @Autowired
    private My my;

    @Autowired
    private Test test;

    @RequestMapping("my")
    public void myInYml()
    {
        System.out.println(my.toString());
    }

    @RequestMapping("test")
    public void testPoper()
    {
        System.out.println(test.toString());
    }
}
