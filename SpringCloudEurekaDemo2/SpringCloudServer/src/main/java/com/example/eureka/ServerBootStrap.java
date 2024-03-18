package com.example.eureka;

import com.netflix.discovery.TimedSupervisorTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(ServerBootStrap.class);
    }
}
