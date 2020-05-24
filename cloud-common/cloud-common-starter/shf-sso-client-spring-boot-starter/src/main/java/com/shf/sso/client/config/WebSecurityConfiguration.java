package com.shf.sso.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 描述：授权服务器 主要是配置客户端信息和认证信息
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
@Order(90)
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 用于访问认证服务器
     */
    @Autowired
    private ResourceServerTokenServices tokenServices;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 创建自定义Filter，有两种构造方式，分别对应不同的架构模式
         */
        AppAuthenticationProcessFilter appAuthenticationProcessFilter =
                new AppAuthenticationProcessFilter(tokenServices);

        http
                /**
                 * 将自定义Filter加入FilterChain
                 */
                .addFilterAfter(
                        appAuthenticationProcessFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    /**
     * 定义TokenStore
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
}