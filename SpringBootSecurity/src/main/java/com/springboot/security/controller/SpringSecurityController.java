package com.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSecurityController {

    @RequestMapping("/")
    public String root()
    {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/login")
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

    @RequestMapping("/401")
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
