package com.steven.mq.emqx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date: 2022/8/12.
 * @version: 1.8.
 */
@SpringBootApplication
public class EmqxServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmqxServerApplication.class, args);
    }
}
