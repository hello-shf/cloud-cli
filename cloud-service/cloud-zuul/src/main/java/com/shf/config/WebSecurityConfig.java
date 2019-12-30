package com.shf.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author shf
 * @date 2019-03-03
 */
@EnableOAuth2Sso
@Configuration
@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                    .logoutSuccessUrl("http://localhost:8080/logout")
                    .and()
                .authorizeRequests()
                    .antMatchers("/test").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .csrf()
                    .disable();
    }
}

