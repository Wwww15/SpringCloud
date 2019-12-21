package com.springcloud.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@Configuration
public class JwtConfig {


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public TokenStore tokenStore()
    {
        return  new JwtTokenStore(jwtAccessTokenConverter());
    }

    public JwtAccessTokenConverter jwtAccessTokenConverter()
    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        ClassPathResource resource = new ClassPathResource("public-jwt.cer");
        try {
            converter.setVerifierKey(new String(FileCopyUtils.copyToByteArray(resource.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return converter;
    }

}
