package com.steven.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.drpanda.pad.infra.common.model.BaseEntityModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author: dr.panda.
 * @date: 2022/9/11.
 * @description: com.drpanda.lighthouse.domain.
 * @version: 1.8.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_dp_classify")
public class ClassifyDomain extends BaseEntityModel<ClassifyDomain> implements Serializable {

    private String classifyName;

    private Long parentId;

    private Integer depth;

    private String path;

    private Short classifyType;
}
