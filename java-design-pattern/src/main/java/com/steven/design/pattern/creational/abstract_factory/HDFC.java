package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class HDFC implements Bank {

    private String bankName = null;

    public HDFC() {
        this.bankName = "HDFC BANK";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}
