package com.steven.mybatis.plus.controller;

import com.drpanda.pad.infra.common.resp.Resp;
import com.steven.mybatis.plus.domain.ClassifyDomain;
import com.steven.mybatis.plus.service.ClassifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: dr.panda.
 * @date: 2022/9/11.
 * @description: com.steven.mybatis.plus.domain.
 * @version: 1.8.
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;

    @GetMapping("/list")
    public Resp<List<ClassifyDomain>> listAll() {
        return Resp.success(classifyService.listAll());
    }
}
