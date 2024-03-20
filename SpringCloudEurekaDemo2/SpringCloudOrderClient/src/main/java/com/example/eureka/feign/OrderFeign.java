package com.example.eureka.feign;

import com.example.eureka.po.OrderPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 这里的name为spring.application.name
 */
@FeignClient(name = "point-client",fallback = OrderSentinelProcessor.class)
public interface OrderFeign {

    @PostMapping("/point/new")
    void processPoint(@RequestBody OrderPo orderPo);
}
