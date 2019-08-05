package com.springcloud.demo.controller;

import com.springcloud.demo.bean.User;
import com.springcloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("one")
    public User getUserById(Integer id)
    {
        return  userService.getUserById(id);
    }

    @PostMapping("one")
    public String insertUser(User user)
    {
        return userService.insertUser(user);
    }
}
