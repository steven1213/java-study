package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
