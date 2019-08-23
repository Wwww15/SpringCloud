package com.springcloud.eurekafeignclient.controller;

import com.springcloud.eurekafeignclient.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("feignHi")
    public  String sayHi()
    {
        return feignService.sayHi();
    }
}
