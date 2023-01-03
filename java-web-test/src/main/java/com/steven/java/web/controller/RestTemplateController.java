package com.steven.java.web.controller;

import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.steven.java.web.utils.EncryptUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: dr.panda.
 * @date: 2022/9/21.
 * @description: com.steven.java.web.controller.
 * @version: 1.8.
 */
@RestController
@RequestMapping("/resttemplate/test")
public class RestTemplateController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/video")
    public String videoGet() {

        String appId = "SKORBXMI";
        String appSecret = "f2ba2db4047a9c6991550b6f6099500e";
        String path = "/contentapi/video/getVideoUrls";

        VideoUrlReq build = VideoUrlReq.builder()
                .videoIdList(new String[]{"0d24f588ec4c452394c32b0aac7b1e22"})
                .build();
        HttpEntity<String> request = new HttpEntity<>(JSONUtil.toJsonStr(build), getHttpHeader(appId, path));
        String url = "https://apigateway.jiaoyanyun.com/" + path + "?extraData=" + EncryptUtils.base64Encode(JSONUtil.toJsonStr(GatewayExtraData.builder()
                .user(GateWayUser.builder().build())
                .build()));
        ResponseEntity<String> responseBody = restTemplate.postForEntity(url, request, String.class);

        if (responseBody.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(responseBody.getBody());
        } else {
            System.out.println("error");
        }
        return "hello";
    }

    private HttpHeaders getHttpHeader(String appKey, String path) {
        Long timeStamp = System.currentTimeMillis();
        String nonce = UUID.randomUUID().toString().replace("-", "");

        StringBuilder sb = new StringBuilder();
        sb.append(appKey).append("-").append(path).append("-").append(timeStamp).append("-").append(nonce);

        String sign = EncryptUtils.getSHA256Str(sb.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        headers.add("X-Api-Key", appKey);
        headers.add("X-Api-Version", "1");
        headers.add("X-Api-Signature", sign);
        headers.add("X-Api-Timestamp", String.valueOf(timeStamp));
        headers.add("X-Api-Nonce", nonce);
        return headers;
    }
}
