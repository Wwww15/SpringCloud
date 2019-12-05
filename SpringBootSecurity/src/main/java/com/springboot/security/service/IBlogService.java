package com.springboot.security.service;

import com.springboot.security.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBlogService {

    List<Blog> getBlogs();

    void delateBlog(Long id);
}
