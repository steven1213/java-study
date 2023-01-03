package com.steven.java.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: dr.panda.
 * @date: 2022/9/21.
 * @description: com.steven.java.web.
 * @version: 1.8.
 */
@ComponentScan(basePackages = {"com.steven.java"})
@SpringBootApplication
public class JavaWebTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebTestApplication.class, args);
    }
}
