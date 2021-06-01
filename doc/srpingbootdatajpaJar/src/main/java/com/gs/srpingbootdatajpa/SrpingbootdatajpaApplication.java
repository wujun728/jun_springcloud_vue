package com.gs.srpingbootdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gs")
public class SrpingbootdatajpaApplication {
   //     extends SpringBootServletInitializer {

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SrpingbootdatajpaApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SrpingbootdatajpaApplication.class, args);
    }
}