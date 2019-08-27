package com.springcloud.eurekaribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi()
    {
        String url="http://eureka-client/hi";
        return restTemplate.getForObject(url,String.class);
    }

    public  String hiError()
    {
        return "hi,It's wrong!";
    }
}
