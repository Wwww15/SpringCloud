package com.springcloud.demo.service;

import com.springcloud.demo.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisDao redisDao;

    public String getValue(String key)
    {
        String value = redisDao.getValue(key);
        return value;
    }

    public void setValue(String key,String value)
    {
        redisDao.setValue(key,value);
    }
}
