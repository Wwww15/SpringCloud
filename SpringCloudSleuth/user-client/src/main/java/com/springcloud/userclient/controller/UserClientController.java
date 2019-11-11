package com.springcloud.userclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserClientController {

    @GetMapping("userclient")
    public String test()
    {
        return  "In the end!";
    }
}
