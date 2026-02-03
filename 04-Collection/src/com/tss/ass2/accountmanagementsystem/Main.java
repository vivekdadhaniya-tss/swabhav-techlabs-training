package com.tss.ass2.accountmanagementsystem;

import com.tss.ass2.accountmanagementsystem.service.AccountManagementSystem;
import com.tss.ass2.accountmanagementsystem.validation.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountManagementSystem system = new AccountManagementSystem(scan);
        int choice;

        do {
            System.out.println("""
            ============================================
                ACCOUNT MANAGEMENT SYSTEM
            ============================================
             1. Create Account
             2. Deposit Amount
             3. Withdraw Amount
             4. Show Balance
             5. View Account Transaction History
             6. View All Transactions
             7. Transfer Amount
             8. Display Account
             9. Display All Accounts
             10. Delete Account
             0. Exit
            --------------------------------------------
            """);

            choice = InputValidator.readInt(scan, "Enter choice: ");

            switch (choice) {
                case 1 -> system.createAccount();
                case 2 -> system.deposit();
                case 3 -> system.withdraw();
                case 4 -> system.showBalance();
                case 5 -> system.viewAccountTransactionHistory();
                case 6 -> system.viewAllTransactions();
                case 7 -> system.transferMoney();
                case 8 -> system.displayAccount();
                case 9 -> system.displayAllAccounts();
                case 10 -> system.deleteAccount();
                case 0 -> System.out.println("Thank you! Exiting...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 0);

        scan.close();
    }
}
