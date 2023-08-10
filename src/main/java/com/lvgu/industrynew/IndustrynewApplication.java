package com.lvgu.industrynew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lvgu.industrynew.mapper")
public class IndustrynewApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndustrynewApplication.class, args);
    }

}
