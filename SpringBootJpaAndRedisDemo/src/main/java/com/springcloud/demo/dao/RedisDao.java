package com.springcloud.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public String getValue(String key)
    {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        String value = opsForValue.get(key);
        return value;
    }

    public void setValue(String key, String value)
    {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.set(key,value);
    }
}
