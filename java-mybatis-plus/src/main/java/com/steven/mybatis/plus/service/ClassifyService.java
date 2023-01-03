package com.steven.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.steven.mybatis.plus.domain.ClassifyDomain;

import java.util.List;

/**
 * @author: dr.panda.
 * @date: 2022/9/11.
 * @description: com.drpanda.lighthouse.application.
 * @version: 1.8.
 */
public interface ClassifyService extends IService<ClassifyDomain> {

    List<ClassifyDomain> listAll();
}
