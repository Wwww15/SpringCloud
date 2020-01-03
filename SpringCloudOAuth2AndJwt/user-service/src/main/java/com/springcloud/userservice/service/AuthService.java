package com.springcloud.userservice.service;

import com.springcloud.userservice.config.FeignConfig;
import com.springcloud.userservice.entity.MyJWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//feign调用serviceId和熔断器
@FeignClient(value = "auth-service",fallback = FeignHystrix.class,configuration = FeignConfig.class)
public interface AuthService {

    @PostMapping("/oauth/token")
    MyJWT getToken(@RequestParam("client_id") String client_id, @RequestParam("client_secret")String client_secret, @RequestParam("grant_type") String grant_type);

}
