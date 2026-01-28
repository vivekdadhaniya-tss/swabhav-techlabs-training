package com.tss.ass7.service;

import com.tss.ass7.model.Account;
import com.tss.ass7.validation.InputValidator;

import java.util.Scanner;

public class AccountService {

    private final Account account;
    private final Scanner scan;

    public AccountService(Account account, Scanner scan) {
        this.account = account;
        this.scan = scan;
    }

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
        double amount = InputValidator.readPositiveDouble(scan, "Enter withdraw amount: ");
        if (amount == -1) return;
        account.withdraw(amount);

    }

    public void deposit() {
        if (account == null) {
            System.out.println("Create account first");
            return;
        }
        double amount = InputValidator.readPositiveDouble(scan, "Enter deposit amount: ");
        if (amount == -1) return;
        account.deposit(amount);

    }
}
