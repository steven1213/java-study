package com.steven.design.pattern.creational.abstract_factory;

import java.io.IOException;
import java.util.Scanner;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
public class AbstractFactoryPatternExample {
    public static void main(String args[]) throws IOException {

        Scanner br = new Scanner(System.in);

        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName = br.nextLine();

        System.out.print("\n");
        System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");

        String loanName = br.nextLine();
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank b = bankFactory.getBank(bankName);

        System.out.print("\n");
        System.out.print("Enter the interest rate for " + b.getBankName() + ": ");

        double rate = br.nextDouble();
        System.out.print("\n");
        System.out.print("Enter the loan amount you want to take: ");

        double loanAmount = br.nextDouble();
        System.out.print("\n");
        System.out.print("Enter the number of years to pay your entire loan amount: ");
        int years = br.nextInt();

        System.out.print("\n");
        System.out.println("you are taking the loan from " + b.getBankName());

        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan l = loanFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount, years);
    }
}
