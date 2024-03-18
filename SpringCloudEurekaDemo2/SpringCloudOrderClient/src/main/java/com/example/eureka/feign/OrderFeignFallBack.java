package com.example.eureka.feign;

import com.example.eureka.po.OrderPo;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignFallBack implements OrderFeign{

    @Override
    public void processPoint(OrderPo orderPo) {
        System.out.println("当前订单处理失败！");
    }
}
