package com.springcloud.eurekafeignclient.service;

import com.springcloud.eurekafeignclient.config.FallBack;
import com.springcloud.eurekafeignclient.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = FallBack.class)
public interface FeignService {

    @GetMapping("hi")
    public String sayHi();
}
