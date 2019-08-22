package com.springcloud.eurekaribbonclient.controller;

import com.springcloud.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService ;

    @GetMapping("hi")
    public String hi()
    {
       return ribbonService.hi();
    }
}
