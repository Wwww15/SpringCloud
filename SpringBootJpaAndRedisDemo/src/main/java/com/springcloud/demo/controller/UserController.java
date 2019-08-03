package com.springcloud.demo.controller;

import com.springcloud.demo.bean.User;
import com.springcloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("one")
    public User getUserById(Integer id)
    {
        return  userService.getUserById(id);
    }
}
