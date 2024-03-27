package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamProviderBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(StreamProviderBootStrap.class,args);
    }
}
