package com.normdevstorm.never_give_up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class TechShop {

    public static void main(String[] args) {
        SpringApplication.run(TechShop.class, args);
    }

}
