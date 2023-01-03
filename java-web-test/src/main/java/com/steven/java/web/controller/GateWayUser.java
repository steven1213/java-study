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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GateWayUser implements Serializable {

    @Builder.Default
    private String userId = "test";
    @Builder.Default
    private String userName = "test";
    @Builder.Default
    private String roleCode = "1";
}
