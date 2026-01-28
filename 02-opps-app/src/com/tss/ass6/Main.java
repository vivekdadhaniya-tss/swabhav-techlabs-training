package com.tss.ass6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountService accountService = new AccountService();
        int choice;

        do {
            System.out.println("""
                    
                    1. Create Account
                        a. Savings
                        b. Current
                    2. Deposit
                    3. Withdraw
                    4. Show Balance
                    5. Exit
                    
                    """);

            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> accountService.createAccount();
                case 2 -> accountService.deposit();
                case 3 -> accountService.withdraw();
                case 4 -> accountService.showBalance();
                case 5 -> System.out.println("Thank you! Exiting...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 5);

        scan.close();
    }

//    public static void selectAccount() {
//        if(availableAccounts == 0) {
//            System.out.println("No Accounts available");
//        }
//    }

}