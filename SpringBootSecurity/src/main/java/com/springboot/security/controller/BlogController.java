package com.springboot.security.controller;

import com.springboot.security.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {


    @Autowired
    private IBlogService service;

    @GetMapping
    public String list(Model model)
    {
        model.addAttribute("blogList",service.getBlogs());
        return "blogs/list";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id, Model model)
    {
        service.delateBlog(id);
        model.addAttribute("blogList",service.getBlogs());
        return "blogs/list";
    }
}
