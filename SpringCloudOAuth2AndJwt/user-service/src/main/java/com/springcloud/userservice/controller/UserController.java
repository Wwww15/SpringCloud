package com.springcloud.userservice.controller;

import com.springcloud.userservice.entity.MyJWT;
import com.springcloud.userservice.entity.MyResponse;
import com.springcloud.userservice.entity.User;
import com.springcloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("one")
    public void register(User user)
    {
        userService.addUser(user);
    }

    @PostMapping("login")
    public MyResponse<MyJWT> login(User user)
    {
        return userService.login(user);
    }

    @GetMapping("current")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Principal getUser(Principal principal)
    {
        return principal;
    }
}
