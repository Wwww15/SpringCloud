package com.example.euraka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("gateway")
public class GateWayController {

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("applicationName")
    public String applicationName() {
        return name;
    }
}
