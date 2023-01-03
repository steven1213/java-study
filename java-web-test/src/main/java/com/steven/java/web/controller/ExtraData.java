package com.steven.java.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ExtraData implements Serializable {

    @JsonProperty("organizationCode")
    private String organizationCode;
    @JsonProperty("sceneCode")
    private String sceneCode;
    @JsonProperty("identityCode")
    private String identityCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cityCode")
    private String cityCode;
    @JsonProperty("email")
    private String email;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("userIp")
    private String userIp;
    @JsonProperty("jobNumber")
    private String jobNumber;
    @JsonProperty("subjectId")
    private Integer subjectId;
    @JsonProperty("gradeGroupId")
    private Integer gradeGroupId;
}
