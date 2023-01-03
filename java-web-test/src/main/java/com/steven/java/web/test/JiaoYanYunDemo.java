package com.steven.java.web.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author tongchao
 * @belongsProject demo
 * @belongsPackage com.example.demo
 * @createTime 2022-09-16  17:32:13
 * @description TODO DOC ME
 */
public class JiaoYanYunDemo {

//    【必选】X-Api-Key：AppKey。
//    【可选】X-Api-Version：API版本号，默认为1。
//    【必选】X-Api-Signature：签名字符串，大写字符串。(参考1.2步骤生成)
//    【必选】X-Api-Timestamp：API 调用者传递时间戳，值为当前时间的毫秒数，也就是从1970年1 月1日起至今的时间转换为毫秒，时间戳有效时间为5分钟。
//    【必选】X-Api-Nonce：API 调用者生成的 随机数，建议UUID，不能包含中划线“-”，结合时间戳 防重放。
//    【必选】Content-Type 统一为application/json

    private static final String appKey = "SKORBXMI";

    private static final String appSecret = "f2ba2db4047a9c6991550b6f6099500e";

    private static final String host = "https://apigateway.jiaoyanyun.com";
    private static final String path = "/contentapi/video/getVideoUrls";

    public static void main(String[] args) {

        Long timestamp = System.currentTimeMillis();
        String nonce = genUUID();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", appKey);
        headers.set("X-Api-Version", String.valueOf(1));
        headers.set("X-Api-Signature", sign(path, timestamp, nonce));
        headers.set("X-Api-Timestamp", timestamp.toString());
        headers.set("X-Api-Nonce", nonce);
        headers.set("Content-Type", "application/json");

        JSONObject dataJS = new JSONObject();
        JSONObject userJs = new JSONObject();
        userJs.put("userId", "test");
        userJs.put("userName", "test");
        userJs.put("roleCode", "1");
        dataJS.put("user", userJs);

        String extraData = Base64.getEncoder().encodeToString(dataJS.toString().getBytes());

//        System.out.println(extraData);

        String url = host + path + "?extraData=" + extraData;

        JSONObject body = new JSONObject();
        body.put("extraData", new JSONObject());
        body.put("videoIdList", new String[]{"25507371992e44b0b50dc009222117fc"});

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body.toJSONString(), headers), String.class);

        System.out.println(response.getBody());
    }

    /**
     * 签名方法
     *
     * @param timestamp
     * @param nonce
     * @return
     */
    private static String sign(String path, Long timestamp, String nonce) {
        String signOriginalString = appKey + "-" + path + "-" + timestamp + "-" + nonce + "-" + appSecret;
        return getSHA256StrJava(signOriginalString).toUpperCase();
    }

    /**
     * 生成UUID
     *
     * @return
     */
    private static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 利用java原生的摘要实现SHA256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
