package com.shf.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/27 14:49
 * @Version V1.0
 **/
//@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*"); // 允许域名

        corsConfiguration.addAllowedHeader("*"); // 允许头

        corsConfiguration.addAllowedMethod("*"); // 允许方法
        //cookie + session
//        corsConfiguration.setAllowCredentials(true);

        return corsConfiguration;

    }

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", buildConfig());

        return new CorsFilter(urlBasedCorsConfigurationSource);

    }

}