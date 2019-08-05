package com.springcloud.demo.service;

import com.springcloud.demo.bean.User;
import com.springcloud.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id)
    {
        User one = userDao.getOne(id);
        return one;
    }

    public String insertUser(User user) {
        User one = userDao.save(user);
        if(ObjectUtils.isEmpty(one.getId()))
        {
            return "失败";
        }
        return "成功";
    }
}
