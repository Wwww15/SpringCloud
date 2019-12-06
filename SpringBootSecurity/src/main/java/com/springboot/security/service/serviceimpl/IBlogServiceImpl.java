package com.springboot.security.service.serviceimpl;

import com.springboot.security.entity.Blog;
import com.springboot.security.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IBlogServiceImpl implements IBlogService {

    private List<Blog> blogs = new ArrayList<>();

    public IBlogServiceImpl() {

        blogs.add(new Blog(1l," JAVA ","LIKE "));
        blogs.add(new Blog(2l," C# ","HATE "));

    }

    @Override
    public List<Blog> getBlogs() {
        return blogs;
    }

    @Override
    public void delateBlog(Long id) {
        Iterator<Blog> iterator = blogs.iterator();
        while (iterator.hasNext())
        {
            Blog blog = iterator.next();
            if(blog.getId()==id)
            {
                iterator.remove();
                return;
            }
        }
    }
}
