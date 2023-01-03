package com.steven.eqmx.connection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dr.panda.
 * @date: 2022/9/14.
 * @description: com.steven.eqmx.connection.controller.
 * @version: 1.8.
 */
@RestController
@RequestMapping("/emqx/connection")
public class ConnectionTestController {

    private String username = "drpanda_pad";

    private String password = "Z#tfhL4agb$hi+dJ&zfQ#7z4YZ%yODlL";

    private String clientIdTemplate = "steven_%07d";

    @GetMapping("/test")
    public void test() {
        for (int i = 1; i < 2; i++) {
            String clientId = String.format(clientIdTemplate, i);
            ConnectionThread connectionThread = new ConnectionThread(clientId, username, password);
            Thread t = new Thread(connectionThread);
            t.start();
        }
    }
}
