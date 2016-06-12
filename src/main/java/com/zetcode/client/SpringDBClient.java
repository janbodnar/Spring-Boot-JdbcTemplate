package com.zetcode.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.zetcode")
public class SpringDBClient {

    public static void main(String[] args) {

        SpringApplication.run(SpringDBClient.class, args);
    }
}
