package com.tss.ass5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = scan.nextInt();

        System.out.print("Enter account number: ");
        int accNo = scan.nextInt();

        System.out.print("Enter name: ");
        String name = scan.nextLine();

        System.out.print("Enter balance: ");
        int balance = scan.nextInt();

        System.out.println("Select Account Type:");
        System.out.println("1. SAVINGS");
        System.out.println("2. CURRENT");
        System.out.println("3. SALARY");

        int choice = scan.nextInt();
        AccountType type = switch (choice) {
            case 1 -> AccountType.SAVINGS;
            case 2 -> AccountType.CURRENT;
            case 3 -> AccountType.SALARY;
            default -> {
                System.out.println("Invalid choice. Default SAVINGS.");
                yield AccountType.SAVINGS;
            }
        };

        Account acc = new Account(id, accNo, name, balance, type);
        System.out.println(acc);

        System.out.println("Total Accounts: " + Account.counter);
    }
}
