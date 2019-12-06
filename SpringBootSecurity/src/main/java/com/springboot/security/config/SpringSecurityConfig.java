package com.springboot.security.config;

import com.springboot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }


/*    //内存方式
    public UserDetailsService userDetailsService()
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("kevin123").password(new BCryptPasswordEncoder().encode("12345")).roles("admin").build());
        manager.createUser(User.withUsername("smith123").password(new BCryptPasswordEncoder().encode("12345")).roles("user","admin").build());
        return  manager;
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .mvcMatchers("/css/**","/index").permitAll()
            .mvcMatchers("/security/**").hasRole("ADMIN")
            .and()
            .formLogin().loginPage("/login").failureForwardUrl("/login-error")
            .and()
            .exceptionHandling().accessDeniedPage("/401")
            .and()
            .logout().logoutSuccessUrl("/");
    }
}
