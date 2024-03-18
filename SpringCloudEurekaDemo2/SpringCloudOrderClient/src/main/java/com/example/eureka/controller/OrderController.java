package com.example.eureka.controller;

import com.example.eureka.po.OrderPo;
import com.example.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("new")
    public void newOrder(@RequestBody OrderPo orderPo) {
        orderService.order(orderPo);
    }
}
