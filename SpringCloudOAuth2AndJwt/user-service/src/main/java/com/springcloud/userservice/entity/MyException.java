package com.springcloud.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyException extends RuntimeException {
    public String message;
    public Integer value;
}
