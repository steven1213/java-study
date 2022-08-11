package com.steven.design.pattern.creational.factory.method;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @date: 2022/8/11.
 * @version: 1.8.
 */
@Slf4j
public class GenerateBill {

    public static void main(String[] args) {
        GetPlanFactory planFactory = new GetPlanFactory();
        log.info("Enter the name of plan for which the bill will be generated: ");

        Scanner scanner = new Scanner(System.in);

        String planName = scanner.nextLine();
        log.info("Enter the number of units for bill will be calculated: ");
        int units = scanner.nextInt();

        Plan p = planFactory.getPlan(planName);
        //call getRate() method and calculateBill()method of DomesticPaln.
        p.getRate();
        log.info("Bill amount for {} of {} units is:{}", planName, units, p.calculateBill(units));
    }
}
