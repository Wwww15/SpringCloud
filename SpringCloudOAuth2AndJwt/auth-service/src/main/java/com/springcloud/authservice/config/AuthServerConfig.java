package com.springcloud.authservice.config;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    @Qualifier("authenticationManagerBean")
    public AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("kevin")
                .secret("kevin12345")
                .scopes("client")
                .authorizedGrantTypes("client_credentials","refresh_token")
                .accessTokenValiditySeconds(3600);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //存储策略
                .tokenStore(new JwtTokenStore(jwtTokenEnhancer()))
                //增强策略
                .tokenEnhancer(jwtTokenEnhancer())
                //开启密码授权验证
                .authenticationManager(authenticationManager);
    }



    //jwt身份转换器，用于将封装在jwt里面的信息解析或者转换
    public JwtAccessTokenConverter jwtTokenEnhancer()
    {
        //RSA非对称加密密钥工厂，参数一为密钥地址，参数二为打开密钥的密码
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("auth-jwt.jks"),"jwtsecret12345".toCharArray());
        JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("auth-jwt"));
        return converter;
    }

}
