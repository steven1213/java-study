package com.steven.design.pattern.creational.factory.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
@Slf4j
abstract class Plan {

    protected double rate;

    abstract void getRate();

    public double calculateBill(int unit) {
        return unit * rate;
    }
}
