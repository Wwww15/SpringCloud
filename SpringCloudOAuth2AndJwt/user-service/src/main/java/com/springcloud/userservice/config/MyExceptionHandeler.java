package com.springcloud.userservice.config;

import com.springcloud.userservice.entity.MyException;
import com.springcloud.userservice.entity.MyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//异常类
@ControllerAdvice
public class MyExceptionHandeler{

    @ExceptionHandler(MyException.class)
    public MyResponse<String> myExceptionHandler(Exception ex)
    {
        return new MyResponse<String>(ex.getMessage(), HttpStatus.OK.value());
    }
}
