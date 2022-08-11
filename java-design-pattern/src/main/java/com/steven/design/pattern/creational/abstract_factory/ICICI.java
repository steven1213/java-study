package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class ICICI implements Bank {
    private String bankName = null;

    public ICICI() {
        this.bankName = "ICICI BANK";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}
