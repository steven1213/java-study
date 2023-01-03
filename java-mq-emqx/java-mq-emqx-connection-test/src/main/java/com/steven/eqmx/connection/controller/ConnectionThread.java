package com.steven.eqmx.connection.controller;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/**
 * @author: dr.panda.
 * @date: 2022/9/14.
 * @description: com.steven.eqmx.connection.controller.
 * @version: 1.8.
 */
@Slf4j
public class ConnectionThread implements Runnable {

    private String sn;

    private String username;

    private String password;


    public ConnectionThread(String sn, String username, String password) {
        this.sn = sn;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        try {
            MqttConnectOptions option = getOption(username, password);
            getClient(option);
            Thread.sleep(30 * 1000);
        } catch (Exception ex) {
            log.error("error:",ex);
        }


    }

    public MqttConnectOptions getOption(String username, String password) {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(true);
        //断线重连
        options.setAutomaticReconnect(true);
        // 设置超时时间 单位为秒
        options.setConnectionTimeout(60000);
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*10秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
        options.setKeepAliveInterval(30);
        return options;
    }

    public MqttClient getClient(MqttConnectOptions options) throws Exception {
        MqttClient client = new MqttClient("tcp://emqx.xiongmaoboshi.com:1883", sn);
        client.connect(options);
        return client;
    }
}
