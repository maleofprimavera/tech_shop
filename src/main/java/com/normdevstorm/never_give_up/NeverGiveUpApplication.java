package com.normdevstorm.never_give_up;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class NeverGiveUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeverGiveUpApplication.class, args);
    }

}
