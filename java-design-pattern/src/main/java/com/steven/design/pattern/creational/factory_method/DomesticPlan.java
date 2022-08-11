package com.steven.design.pattern.creational.factory_method;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class DomesticPlan extends Plan {
    @Override
    void getRate() {
        rate = 3.5d;
    }
}
