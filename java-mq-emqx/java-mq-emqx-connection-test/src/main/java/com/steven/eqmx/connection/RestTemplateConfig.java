package com.steven.eqmx.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: dr.panda.
 * @date: 2022/9/13.
 * @description: com.steven.eqmx.connection.
 * @version: 1.8.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
