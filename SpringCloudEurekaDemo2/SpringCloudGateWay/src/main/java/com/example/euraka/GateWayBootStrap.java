package com.example.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GateWayBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(GateWayBootStrap.class,args);
    }
}
