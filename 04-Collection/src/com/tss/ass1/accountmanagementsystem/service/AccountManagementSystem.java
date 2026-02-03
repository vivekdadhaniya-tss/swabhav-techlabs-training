package com.tss.ass1.accountmanagementsystem.service;

import com.tss.ass1.accountmanagementsystem.model.*;
import com.tss.ass1.accountmanagementsystem.model.*;
import com.tss.ass1.accountmanagementsystem.util.AppConstants;
import com.tss.ass1.accountmanagementsystem.util.DisplayUtils;
import com.tss.ass1.accountmanagementsystem.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagementSystem {

    private final List<Account> accounts = new ArrayList<>();
    private final Scanner scan;
    public AccountManagementSystem(Scanner scan) {
        this.scan = scan;
    }

    public void createAccount() {

        if (accounts.size() == AppConstants.MAX_ACCOUNTS) {
            System.out.println("Account limit reached");
            return;
        }

        System.out.print("Choose account type (a/b): ");
        char type = scan.next().charAt(0);

        String name = InputValidator.readValidName(scan, "Enter name: ");
        if (name == null) return;

        double balance = InputValidator.readPositiveDouble(scan, "Enter initial balance: ");
        if (balance == -1) return;

        Account account;

        if (type == 'a') {
            account = new SavingsAccount(name, balance);
        } else if (type == 'b') {
            account = new CurrentAccount(name, balance);
        } else {
            System.out.println("Invalid account type");
            return;
        }

        accounts.add(account);

        System.out.println("Account Created Successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }


    public Account selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return null;
        }

        int accNo = InputValidator.readInt(scan, "Enter account number: ");

        for (Account account : accounts) {
            if (account.getAccountNumber() == accNo) {
                return account;
            }
        }
        System.out.println("Account not found");
        return null;
    }

    private Account findAccountByNumber(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }


    public void transferMoney() {

        if (accounts.size() < 2) {
            System.out.println("At least two accounts are required for transfer");
            return;
        }

        int fromAccNo = InputValidator.readInt(scan, "Enter FROM account number: ");
        int toAccNo   = InputValidator.readInt(scan, "Enter TO account number: ");

        if (fromAccNo == toAccNo) {
            System.out.println("Source and destination accounts cannot be same");
            return;
        }

        Account fromAccount = findAccountByNumber(fromAccNo);
        Account toAccount   = findAccountByNumber(toAccNo);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found");
            return;
        }

        double amount = InputValidator.readPositiveDouble(scan, "Enter transfer amount: ");
        if (amount <= 0) return;

        if (!fromAccount.withdraw(amount, false)) {
            System.out.println("Transfer failed: Insufficient balance");
            return;
        }

        toAccount.deposit(amount, false);

        Transaction transaction = new Transaction(
                fromAccNo,
                toAccNo,
                amount,
                TransactionType.TRANSFER
        );

        fromAccount.addTransaction(transaction);
        toAccount.addTransaction(transaction);

        System.out.println("Transfer successful");
    }

    public void searchAccount() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        int accNo = InputValidator.readInt(scan, "Enter account number: ");
        Account acc = findAccountByNumber(accNo);

        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        DisplayUtils.printAccountDetails(acc);
    }

    public void deleteAccount() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        int accNo = InputValidator.readInt(scan, "Enter account number to delete: ");
        Account acc = findAccountByNumber(accNo);

        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Are you sure you want to delete? (yes/no): ");
        String confirm = scan.next();

        if (confirm.equalsIgnoreCase("yes")) {
            accounts.remove(acc);
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Deletion cancelled");
        }
    }


    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        DisplayUtils.printAllAccounts(accounts);
    }

    public void transactionHistory() {
        if(accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        int accNo = InputValidator.readInt(scan, "Enter account number: ");
        Account acc = findAccountByNumber(accNo);

        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        DisplayUtils.printTransactions(acc.getTransactions());
    }
}
