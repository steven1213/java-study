package com.steven.java.web.controller;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatewayExtraData implements Serializable {
    private GateWayUser user;
}
