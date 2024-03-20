package com.example.eureka;

import com.example.eureka.feign.LoadBalanceStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@LoadBalancerClient(name = "random", configuration = LoadBalanceStrategy.class)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderClientBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(OrderClientBootStrap.class);
    }
}
