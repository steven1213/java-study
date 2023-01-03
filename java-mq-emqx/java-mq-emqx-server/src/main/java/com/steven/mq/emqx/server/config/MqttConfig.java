package com.steven.mq.emqx.server.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

/**
 * @author: dr.panda.
 * @date: 2022/8/15.
 * @description: com.steven.mq.emqx.server.config.
 * @version: 1.8.
 */
@Slf4j
@Data
@Component
@IntegrationComponentScan
public class MqttConfig {

    public static final String CHANNEL_NAME_IN = "mqttInBoundChannel";
    public static final String CHANNEL_NAME_OUT = "mqttOutBoundChannel";

    @Value("${spring.mqtt.broker}")
    private String broker;

    @Value("${spring.mqtt.client-id}")
    private String clientId;

    @Value("${spring.mqtt.default-topic}")
    private String defaultTopic;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.clean-session:true}")
    private boolean cleanSession;

    @Value("${spring.mqtt.keep-alive-interval}")
    private int keepAliveInterval;

    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setPassword(password.toCharArray());
        options.setUserName(username);
        options.setConnectionTimeout(7200);
        options.setCleanSession(false);
        options.setKeepAliveInterval(keepAliveInterval);
        options.setServerURIs(new String[]{broker});
        return options;
    }

    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptions());
        return factory;
    }

    @Bean(name = CHANNEL_NAME_OUT)
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }


    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_OUT)
    public MessageHandler mqttOutbound(MqttPahoClientFactory mqttPahoClientFactory) {
        MqttPahoMessageHandler handler = new MqttPahoMessageHandler(clientId + "_send", mqttPahoClientFactory);
        handler.setAsync(true);
        handler.setDefaultTopic(defaultTopic);
        return handler;
    }

    @Bean(name = CHANNEL_NAME_IN)
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inBound(MqttPahoClientFactory mqttPahoClientFactory, @Qualifier(value = CHANNEL_NAME_IN) MessageChannel mqttInboundChannel) {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId, mqttPahoClientFactory, "drpanda/mqtt/sub/" + clientId);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInboundChannel);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_IN)
    public MessageHandler handler() {
        return message -> log.info("receive message:{}", message.getPayload());
    }

}
