package com.springcloud.demo.controller;

import com.springcloud.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;


    @PostMapping("/one")
    public void setValue(String key,String value)
    {
        redisService.setValue(key,value);
    }

    @GetMapping("one")
    public String getValue(String key)
    {
        String value = redisService.getValue(key);
        return value;
    }
}
