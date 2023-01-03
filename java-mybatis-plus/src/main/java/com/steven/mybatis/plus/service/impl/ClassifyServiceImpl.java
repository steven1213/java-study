package com.steven.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.steven.mybatis.plus.domain.ClassifyDomain;
import com.steven.mybatis.plus.mapper.ClassifyMapper;
import com.steven.mybatis.plus.service.ClassifyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dr.panda.
 * @date: 2022/9/11.
 * @description: com.drpanda.lighthouse.application.impl.
 * @version: 1.8.
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, ClassifyDomain> implements ClassifyService {

    @Override
    public List<ClassifyDomain> listAll() {
        return this.list();
    }
}
