package com.springcloud.eurekaribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String hi()
    {
        String url="http://eureka-client/hi";
        return restTemplate.getForObject(url,String.class);
    }
}
