package com.tss.ass1.accountmanagementsystem;

import com.tss.ass1.accountmanagementsystem.model.Account;
import com.tss.ass1.accountmanagementsystem.service.AccountManagementSystem;
import com.tss.ass1.accountmanagementsystem.service.AccountService;
import com.tss.ass1.accountmanagementsystem.validation.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountManagementSystem system = new AccountManagementSystem(scan);
        int choice;

        do {
            System.out.println("""
            ====================================================
                       ACCOUNT MANAGEMENT SYSTEM
            ====================================================
            
             1. Create Account
                ├─ a. Savings Account
                └─ b. Current Account
            
             2. Deposit Amount
             3. Withdraw Amount
             4. Show Account Balance
             5. View Transaction History
             6. Transfer Amount
             7. Display All Accounts
             8. Search Account
             9. Delete Account
            
             0. Exit
            ----------------------------------------------------
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
                case 5 -> system.transactionHistory();
                case 6 -> system.transferMoney();
                case 7 -> system.displayAllAccounts();
                case 8 -> system.searchAccount();
                case 9 -> system.deleteAccount();
                case 0 -> System.out.println("Thank you! Exiting...");
            }

        } while (choice != 0);

        scan.close();
    }
}
