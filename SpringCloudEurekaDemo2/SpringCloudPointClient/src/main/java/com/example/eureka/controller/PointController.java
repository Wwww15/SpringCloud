package com.example.eureka.controller;

import com.example.eureka.po.OrderPo;
import com.example.eureka.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("point")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping("hi")
    public String hi() throws InterruptedException {
        return "this is point";
    }

    @PostMapping("new")
    public void newPoint(@RequestBody OrderPo orderPo) throws InterruptedException {
        pointService.point(orderPo.getCount(),orderPo.getPerPoint());
    }
}
