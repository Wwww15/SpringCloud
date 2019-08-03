package com.springcloud.demo.service;

import com.springcloud.demo.bean.User;
import com.springcloud.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id)
    {
        User one = userDao.getOne(id);
        return one;
    }
}
