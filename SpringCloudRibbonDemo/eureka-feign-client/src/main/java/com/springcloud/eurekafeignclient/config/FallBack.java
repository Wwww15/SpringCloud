package com.springcloud.eurekafeignclient.config;

import com.springcloud.eurekafeignclient.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FallBack implements FeignService {

    @Override
    public String sayHi() {
        return "hi,It's wrong!";
    }
}
