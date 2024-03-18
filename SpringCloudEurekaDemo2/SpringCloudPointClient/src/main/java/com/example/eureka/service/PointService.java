package com.example.eureka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Value("${server.port}")
    private Integer port;

    public void point(Integer count, Integer perPoint) throws InterruptedException {
        Thread.sleep(50000);
        System.out.println("记录总积分:" + count * perPoint);
        System.out.println("当前端口：" + port);
    }
}
