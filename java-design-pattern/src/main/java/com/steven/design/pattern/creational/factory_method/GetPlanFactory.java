package com.steven.design.pattern.creational.factory_method;

import org.apache.commons.lang3.StringUtils;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class GetPlanFactory {

    private final static String DOMESTIC_PLAN = "DOMESTICPLAN";
    private final static String COMMERCIAL_PLAN = "COMMERCIALPLAN";
    private final static String INSTITUTIONAL_PLAN = "INSTITUTIONALPLAN";

    public Plan getPlan(String planType) {
        if (StringUtils.isBlank(planType)) {
            return null;
        }
        if (DOMESTIC_PLAN.equalsIgnoreCase(planType)) {
            return new DomesticPlan();
        }
        if (COMMERCIAL_PLAN.equalsIgnoreCase(planType)) {
            return new CommercialPlan();
        }
        if (INSTITUTIONAL_PLAN.equalsIgnoreCase(planType)) {
            return new InstitutionalPlan();
        }
        return null;
    }
}
