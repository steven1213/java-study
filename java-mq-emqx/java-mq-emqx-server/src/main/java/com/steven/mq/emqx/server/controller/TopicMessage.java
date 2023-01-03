package com.steven.mq.emqx.server.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: dr.panda.
 * @date: 2022/8/15.
 * @description: com.steven.mq.emqx.server.controller.
 * @version: 1.8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TopicMessage extends BaseMessage {

    private String topics;
}
