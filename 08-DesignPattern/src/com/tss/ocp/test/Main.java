package com.tss.ocp.test;

import com.tss.ocp.model.DiwaliInterest;
import com.tss.ocp.model.FixedDeposit;
import com.tss.ocp.model.HoliInterest;
import com.tss.ocp.model.NewYearInterest;

public class Main {

    public static void main(String[] args) {

        FixedDeposit fd1 = new FixedDeposit(
                "Aarav",
                100000,
                2,
                new DiwaliInterest()
        );

        System.out.println("Account No: " + fd1.getAccNo());
        System.out.println("Name: " + fd1.getName());
        System.out.println("Interest Type: " + fd1.getInterestRate().getClass().getSimpleName());
        System.out.println("Interest Earned: " + fd1.calculateInterest());
        System.out.println("Total Maturity Amount: " + fd1.calculateTotalAmount());


        FixedDeposit fd2 = new FixedDeposit(
                "Jay",
                100000,
                2,
                new HoliInterest()
        );

        System.out.println("\nAccount No: " + fd2.getAccNo());
        System.out.println("Name: " + fd2.getName());
        System.out.println("Interest Type: " + fd2.getInterestRate().getClass().getSimpleName());
        System.out.println("Interest Earned: " + fd2.calculateInterest());
        System.out.println("Total Maturity Amount: " + fd2.calculateTotalAmount());


        FixedDeposit fd3 = new FixedDeposit(
                "Raj",
                100000,
                2,
                new NewYearInterest()
        );

        System.out.println("\nAccount No: " + fd3.getAccNo());
        System.out.println("Name: " + fd3.getName());
        System.out.println("Interest Type: " + fd3.getInterestRate().getClass().getSimpleName());
        System.out.println("Interest Earned: " + fd3.calculateInterest());
        System.out.println("Total Maturity Amount: " + fd3.calculateTotalAmount());
    }
}
