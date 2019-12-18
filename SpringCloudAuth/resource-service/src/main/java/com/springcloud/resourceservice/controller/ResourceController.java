package com.springcloud.resourceservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/resource/test")
    public String test()
    {
        return "hello,admin!";
    }
}
