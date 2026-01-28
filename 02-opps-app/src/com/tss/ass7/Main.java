package com.tss.ass7;

import com.tss.ass7.model.Account;
import com.tss.ass7.service.AccountManagementSystem;
import com.tss.ass7.service.AccountService;
import com.tss.ass7.validation.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountManagementSystem system = new AccountManagementSystem(scan);
        int choice;

        do {
            System.out.println("""
                    
                    1. Create Account
                        a. savings
                        b. current
                    2. Deposit
                    3. Withdraw
                    4. Show Balance
                    5. Transfer Amount
                    6. Exit
                    """);

            choice = InputValidator.readInt(scan, "Enter your choice: ");

            switch (choice) {
                case 1 -> system.createAccount();
                case 2 -> {
                    Account acc = system.selectAccount();
                    if (acc != null) {
                        new AccountService(acc, scan).deposit();
                    }
                }
                case 3 -> {
                    Account acc = system.selectAccount();
                    if (acc != null) {
                        new AccountService(acc, scan).withdraw();
                    }
                }
                case 4 -> {
                    Account acc = system.selectAccount();
                    if (acc != null) {
                        new AccountService(acc, scan).showBalance();
                    }
                }
                case 5 -> system.transferMoney();
                case 6 -> System.out.println("Thank you! Exiting...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 6);

        scan.close();
    }
}
