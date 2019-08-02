package com.springcloud.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Component
@Data
public class My {
    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String descrption;
}
