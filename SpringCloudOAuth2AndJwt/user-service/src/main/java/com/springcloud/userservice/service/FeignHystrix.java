package com.springcloud.userservice.service;

import com.springcloud.userservice.entity.MyJWT;
import org.springframework.stereotype.Component;

//熔断器处理
@Component
public class FeignHystrix implements AuthService {

    @Override
    public MyJWT getToken(String clientId, String clientSecret, String grantType) {
        System.out.println("异常");
        return null;
    }
}
