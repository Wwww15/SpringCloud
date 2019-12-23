package com.springcloud.userservice.service;

import com.springcloud.userservice.dao.UserDao;
import com.springcloud.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private PasswordEncoder passwordEncoder;

   public void addUser(User user)
   {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userDao.save(user);
   }
}
