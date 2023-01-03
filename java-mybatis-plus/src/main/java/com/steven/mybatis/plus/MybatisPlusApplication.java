package com.steven.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: dr.panda.
 * @date: 2022/9/11.
 * @description: com.steven.mybatis.plus.
 * @version: 1.8.
 */
@SpringBootApplication
@MapperScan("com.steven.mybatis.plus.mapper")
@ComponentScan("com.steven.mybatis.plus")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
