package com.springcloud.eurekafeignclient.service;

import com.springcloud.eurekafeignclient.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "eureka-client",configuration = FeignConfig.class)
public interface FeignService {

    @GetMapping("hi")
    public String sayHi();
}
