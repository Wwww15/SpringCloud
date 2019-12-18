package com.springcloud.resourceservice.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
@EnableConfigurationProperties
public class OAuth2ClientConfig {

    //访问各种受保护资源的客户端配置
    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails()
    {
        return new ClientCredentialsResourceDetails();
    }

    //拦截请求并且注入一个新得请求头，也是请求的存储库
    @Bean
    public RequestInterceptor OAuth2FeignRequestInterceptor()
    {
        return  new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(),clientCredentialsResourceDetails());
    }

    //使oauth2授权支持rest类型的请求
    @Bean
    public OAuth2RestTemplate ClientCredentialsRestTemplate()
    {
        return  new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }
}
