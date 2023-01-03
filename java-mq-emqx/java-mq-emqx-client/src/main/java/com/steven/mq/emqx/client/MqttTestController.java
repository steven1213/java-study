package com.steven.mq.emqx.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: dr.panda.
 * @date: 2022/8/12.
 * @description: com.steven.mq.emqx.server.controller.
 * @version: 1.8.
 */
@Order(0)
@Slf4j
@RestController
@RequestMapping("/mqtt")
public class MqttTestController {

    @PostMapping("/auth")
    public String auth(String clientid, String username, String password, HttpServletRequest request) {
        log.info("clientId is:{}", clientid);
        log.info("username is:{}", username);
        log.info("password is:{}", password);
        return "ok";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AuthInfo {
        private String clientId;

        private String username;

        private String password;

    }
}
