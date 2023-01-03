package com.steven.java.web.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: dr.panda.
 * @date: 2022/9/21.
 * @description: com.drpanda.lighthouse.infra.utils.
 * @version: 1.8.
 */
@Slf4j
public final class EncryptUtils {

    private EncryptUtils() {

    }

    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encryptStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            encryptStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("sha256 encrypt error.", e);
        }
        return encryptStr;
    }

    public static String base64Encode(String str) {
        return Base64.encodeBase64String(str.getBytes(StandardCharsets.UTF_8));
    }
}
