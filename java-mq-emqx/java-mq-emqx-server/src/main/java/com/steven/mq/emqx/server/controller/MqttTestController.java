package com.steven.mq.emqx.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.steven.mq.emqx.server.config.MqttGateway;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private MqttGateway mqttGateway;

    @PostMapping("/send/single-msg")
    public String sendSingleMessage(@RequestBody BaseMessage baseMessage) {
        mqttGateway.sendToMqtt(baseMessage.getMsg());
        return "success";
    }

    @PostMapping("/send/topic-msg")
    public String sendTopicMessage(@RequestBody TopicMessage baseMessage) {
        mqttGateway.sendToMqtt(baseMessage.getTopics(), baseMessage.getMsg());
        return "success";
    }

    @PostMapping("/send/topic-qos-msg")
    public String sendTopicQosMessage(@RequestBody TopicQosMessage baseMessage) {
        mqttGateway.sendToMqtt(baseMessage.getTopics(), baseMessage.getQos(), baseMessage.getMsg());
        return "success";
    }

    @PostMapping("/auth")
    public String auth(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            log.info("mqtt_auth_request_param_{} = {}", key, parameterMap.get(key));
        }
        return "ok";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class AuthInfo {
        private String clientId;

        private String username;

        private String password;

    }

}
