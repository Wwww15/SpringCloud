package com.springcloud.authservice.controller;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@EnableResourceServer
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("current")
    public Principal current(Principal principal)
    {
        return principal;
    }
}
