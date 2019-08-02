package com.springcloud.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "test")
public class Test {

    private int age;

    private String name;
}
