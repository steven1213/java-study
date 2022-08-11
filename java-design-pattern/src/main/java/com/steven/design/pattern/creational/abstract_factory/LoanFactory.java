package com.steven.design.pattern.creational.abstract_factory;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class LoanFactory extends AbstractFactory {

    private static final String HOME = "Home";
    private static final String BUSINESS = "Business";
    private static final String EDUCATION = "Education";

    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan == null) {
            return null;
        }
        if (loan.equalsIgnoreCase(HOME)) {
            return new HomeLoan();
        } else if (loan.equalsIgnoreCase(BUSINESS)) {
            return new BussinessLoan();
        } else if (loan.equalsIgnoreCase(EDUCATION)) {
            return new EducationLoan();
        }
        return null;
    }
}
