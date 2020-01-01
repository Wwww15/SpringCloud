package com.springcloud.userservice.entity;

import lombok.Data;

@Data
public class MyJWT {

    String access_token;
    String token_type;
    String expires_in;
    String scope;
}
