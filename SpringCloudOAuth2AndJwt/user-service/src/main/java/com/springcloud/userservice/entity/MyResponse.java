package com.springcloud.userservice.entity;

public class MyResponse<T> {

    public T data;
    public String message;
    public Integer value;

    public MyResponse(String message, Integer value) {
        this.message = message;
        this.value = value;
    }

    public MyResponse(T data,String message, Integer value) {
        this.data = data;
        this.message = message;
        this.value = value;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
