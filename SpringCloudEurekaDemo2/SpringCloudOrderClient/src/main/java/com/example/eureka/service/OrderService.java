package com.example.eureka.service;

import com.example.eureka.feign.OrderFeign;
import com.example.eureka.po.OrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private DiscoveryClient discoveryClient;

    public void order(OrderPo orderPo) {
        testMetaData();
        System.out.println("当前订单：" + orderPo.getName());
        orderFeign.processPoint(orderPo);
    }

    private void testMetaData() {
        List<ServiceInstance> instances = discoveryClient.getInstances("point-client");
        instances.stream().forEach(item -> {
            String host = item.getHost();
            System.out.println(host);
        });
    }
}
