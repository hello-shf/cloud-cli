package com.shf.sso.client.config;

import com.shf.sso.client.handler.PrexAuthExceptionEntryPoint;
import com.shf.sso.client.handler.PrexCustomAccessDeniedHandler;
import com.shf.sso.client.token.PrexCustomJwtAccessTokenConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 描述：oauth2资源服务器
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
@Slf4j
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    /**
     * security的鉴权排除的url列表
     */
    private static final String[] EXCLUDED_AUTH_PAGES = {
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/*/v2/api-docs",
            "/v2/api-docs",
            "/api/socket/**",
            "/log",
            "/actuator/**",
            "/*/api-docs",
            "/sendCode/**", "/mobile/login/**", "/oauth/**", "/repeatCheck/check",
            "/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico", "/index",
            "/*.html", "/**/*.html", "/**/*.css", "/**/*.js","/user/info/**","/user/social/info"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(EXCLUDED_AUTH_PAGES).permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .authenticationEntryPoint(new PrexAuthExceptionEntryPoint())
                .accessDeniedHandler(new PrexCustomAccessDeniedHandler());
    }

    @Bean
    public TokenStore
    tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new PrexCustomJwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;

    }

}
