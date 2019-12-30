package com.springcloud.userservice.service;

import com.springcloud.userservice.dao.UserDao;
import com.springcloud.userservice.entity.MyException;
import com.springcloud.userservice.entity.MyResponse;
import com.springcloud.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.Jwt;
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

   public MyResponse<Jwt> login(User user)
   {
      User findUser = userDao.findUserByUsername(user.getUsername());
      if(null==findUser)
      {
         throw new MyException("用户名错误！",501);
      }
      else if(!passwordEncoder.matches(user.getPassword(),findUser.getPassword()))
      {
         throw new MyException("密码错误！",502);
      }
      return null;
   }
}
