package com.springboot.security.dao;

import com.springboot.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
