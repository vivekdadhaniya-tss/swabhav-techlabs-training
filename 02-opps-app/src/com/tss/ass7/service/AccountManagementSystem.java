package com.tss.ass7.service;

import com.tss.ass7.model.Account;
import com.tss.ass7.model.CurrentAccount;
import com.tss.ass7.model.SavingsAccount;
import com.tss.ass7.util.AppConstants;
import com.tss.ass7.validation.InputValidator;

import java.util.Scanner;

public class AccountManagementSystem {

    private final Account[] accounts = new Account[AppConstants.MAX_ACCOUNTS];
    private int count = 0;
    private final Scanner scan;

    public AccountManagementSystem(Scanner scan) {
        this.scan = scan;
    }


    public void createAccount() {
        if (count == accounts.length) {
            System.out.println("Account limit reached");
            return;
        }

        System.out.print("Choose account type (a/b): ");
        char type = scan.next().charAt(0);

        String name = InputValidator.readValidName(scan, "Enter name: ");
        if (name == null) return;

        double balance = InputValidator.readPositiveDouble(scan, "Enter initial balance: ");
        if (balance == -1) return;


        Account account = null;

        if (type == 'a') {
            account = new SavingsAccount(name, balance);
        } else if (type == 'b') {
            account = new CurrentAccount(name, balance);
        } else {
            System.out.println("Invalid account type");
            return;
        }

        accounts[count++] = account;
        System.out.println("Account Created Successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public Account selectAccount() {
        if (count == 0) {
            System.out.println("No accounts available");
            return null;
        }

        int accNo = InputValidator.readInt(scan, "Enter account number: ");

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }

        System.out.println("Account not found");
        return null;
    }

    private Account findAccountByNumber(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    public void transferMoney() {

        if(count < 2) {
            System.out.println("Not sufficient account for transfer amount");
            return;
        }

        int fromAccNo = InputValidator.readInt(scan, "Enter FROM account number: ");
        int toAccNo = InputValidator.readInt(scan, "Enter TO account number: ");

        if (fromAccNo == toAccNo) {
            System.out.println("Source and destination accounts cannot be same");
            return;
        }

        Account fromAccount = findAccountByNumber(fromAccNo);
        Account toAccount = findAccountByNumber(toAccNo);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found");
            return;
        }

        double amount = InputValidator.readPositiveDouble(scan, "Enter transfer amount: ");
        if (amount == -1) return;

        double beforeBalance = fromAccount.getBalance();
        fromAccount.withdraw(amount);

        // If withdrawal failed, balance will not change
        if (fromAccount.getBalance() == beforeBalance) {
            System.out.println("Transfer failed due to insufficient balance");
            return;
        }

        toAccount.deposit(amount);
        System.out.println("Transfer successful");
    }
}
