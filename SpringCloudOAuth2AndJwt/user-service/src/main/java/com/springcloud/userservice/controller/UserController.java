package com.springcloud.userservice.controller;

import com.springcloud.userservice.entity.MyJWT;
import com.springcloud.userservice.entity.MyResponse;
import com.springcloud.userservice.entity.User;
import com.springcloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
