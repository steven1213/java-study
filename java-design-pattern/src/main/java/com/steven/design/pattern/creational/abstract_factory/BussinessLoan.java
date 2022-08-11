package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class BussinessLoan extends Loan{

    @Override
    public void getInterestRate(double r){
        rate=r;
    }
}
