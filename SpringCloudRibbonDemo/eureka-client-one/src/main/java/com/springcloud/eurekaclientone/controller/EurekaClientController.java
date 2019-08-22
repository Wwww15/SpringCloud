package com.springcloud.eurekaclientone.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String hi(){
        return "I am kevin,this is "+port+" ! I am 17 years old.";
    }
}
