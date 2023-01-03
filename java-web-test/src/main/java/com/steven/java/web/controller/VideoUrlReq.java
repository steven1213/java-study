package com.steven.java.web.controller;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: dr.panda.
 * @date: 2022/9/21.
 * @description: com.steven.java.web.controller.
 * @version: 1.8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoUrlReq implements Serializable {

    private String[] videoIdList;

    @Builder.Default
    private JsonObject extraData = new JsonObject();
}
