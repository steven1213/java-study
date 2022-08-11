package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class BankFactory extends AbstractFactory {

    private static final String HDFC = "HDFC";
    private static final String ICICI = "ICICI";
    private static final String SBI = "SBI";

    @Override
    public Bank getBank(String bank) {
        if (bank == null) {
            return null;
        }
        if (bank.equalsIgnoreCase(HDFC)) {
            return new HDFC();
        } else if (bank.equalsIgnoreCase(ICICI)) {
            return new ICICI();
        } else if (bank.equalsIgnoreCase(SBI)) {
            return new SBI();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
