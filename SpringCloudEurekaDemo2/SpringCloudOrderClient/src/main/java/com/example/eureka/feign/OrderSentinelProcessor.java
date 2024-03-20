package com.example.eureka.feign;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.eureka.po.OrderPo;
import org.springframework.stereotype.Component;

@Component
public class OrderSentinelProcessor implements OrderFeign{

    @Override
    public void processPoint(OrderPo orderPo) {
        System.out.println("系统繁忙！");
    }
}
