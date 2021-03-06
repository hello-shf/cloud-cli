package com.shf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.shf.jdbc.*.mapper")
@EnableEurekaClient
@SpringBootApplication
public class CloudJdbcUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudJdbcUserApplication.class, args);
    }

}
