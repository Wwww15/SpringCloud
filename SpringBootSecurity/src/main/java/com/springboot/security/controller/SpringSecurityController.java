package com.springboot.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

    @GetMapping("/")
    public String root()
    {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model)
    {
        model.addAttribute("errorMsg","登陆错误！");
        return "login";
    }

    @GetMapping("/401")
    public String notFound()
    {
        return  "401";
    }

    @RequestMapping("/security/test")
    public String security()
    {
        return "security/test";
    }

}
