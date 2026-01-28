package com.tss.ass6;

import java.util.Scanner;

public class AccountService {

    static Scanner scan = new Scanner(System.in);
    static Account account = null;
    //    static Account[] accounts = new Account[5];
    static int availableAccounts = 0;

    public void showBalance() {
        if (account == null) {
            System.out.println("Create account first");
        } else {
            System.out.println("Account No: " + account.getAccountNumber());
            System.out.println("Name: " + account.getName());
            System.out.println("Balance: " + account.getBalance());
        }
    }

    public void withdraw() {
        if (account == null) {
            System.out.println("Create account first");
            return;
        }
        System.out.print("Enter withdraw amount: ");
        double withdraw = scan.nextDouble();
        account.withdraw(withdraw);
    }

    public void deposit() {
        if (account == null) {
            System.out.println("Create account first");
            return;
        }
        System.out.print("Enter deposit amount: ");
        account.deposit(scan.nextDouble());
    }

    public void createAccount() {
        System.out.print("Choose account type (a/b): ");
        char type = scan.next().charAt(0);

        System.out.print("Enter name: ");
        String name = scan.next();

        System.out.print("Enter initial balance: ");
        double balance = scan.nextDouble();

        if (type == 'a') {
            account = new SavingsAccount(name, balance);
            System.out.println("Savings Account Created");
            availableAccounts++;
        } else if (type == 'b') {
            account = new CurrentAccount(name, balance);
            System.out.println("Current Account Created");
            availableAccounts++;
        } else {
            System.out.println("Invalid account type");
        }
    }
}
