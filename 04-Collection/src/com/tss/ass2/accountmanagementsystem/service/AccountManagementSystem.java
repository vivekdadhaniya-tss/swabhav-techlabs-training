package com.tss.ass2.accountmanagementsystem.service;

import com.tss.ass2.accountmanagementsystem.model.*;
import com.tss.ass2.accountmanagementsystem.util.AppConstants;
import com.tss.ass2.accountmanagementsystem.util.DisplayUtils;
import com.tss.ass2.accountmanagementsystem.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagementSystem {

    private final List<Account> accounts = new ArrayList<>();
    private final TransactionService transactionService = new TransactionService();
    private final AccountService accountService = new AccountService(transactionService);
    private final Scanner scan;

    public AccountManagementSystem(Scanner scan) {
        this.scan = scan;
    }

    private boolean hasAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return false;
        }
        return true;
    }

    private Account findAccountByNumber(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    private Account selectAccount() {
        if (!hasAccounts()) return null;

        int accNo = InputValidator.readInt(scan, "Enter account number: ");
        Account acc = findAccountByNumber(accNo);

        if (acc == null) {
            System.out.println("Account not found");
        }
        return acc;
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

        Account account = switch (type) {
            case 'a' -> new SavingsAccount(name, balance);
            case 'b' -> new CurrentAccount(name, balance);
            default -> null;
        };

        if (account == null) {
            System.out.println("Invalid account type");
            return;
        }

        accounts.add(account);
        System.out.println("Account created successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public void deposit() {
        Account acc = selectAccount();
        if (acc == null) return;

        double amount = InputValidator.readPositiveDouble(scan, "Enter deposit amount: ");
        if (amount == -1) return;

        accountService.deposit(acc, amount);
        System.out.println("Deposit successful. Balance: " + acc.getBalance());
    }

    public void withdraw() {
        Account acc = selectAccount();
        if (acc == null) return;

        double amount = InputValidator.readPositiveDouble(scan, "Enter withdraw amount: ");
        if (amount == -1) return;

        if (!accountService.withdraw(acc, amount)) {
            System.out.println("Withdraw failed");
        } else {
            System.out.println("Withdraw successful. Balance: " + acc.getBalance());
        }
    }

    public void transferMoney() {
        if (accounts.size() < 2) {
            System.out.println("At least two accounts are required for transfer");
            return;
        }

        System.out.println("Sender details");
        Account from = selectAccount();
        if (from == null) return;

        System.out.println("Receiver details");
        Account to = selectAccount();
        if (to == null || from == to) {
            System.out.println("Invalid destination account");
            return;
        }

        double amount = InputValidator.readPositiveDouble(scan, "Enter transfer amount: ");
        if (amount == -1) return;

        if (!accountService.transfer(from, to, amount)) {
            System.out.println("Transfer failed");
        } else {
            System.out.println("Transfer successful");
        }
    }

    public void showBalance() {
        Account acc = selectAccount();
        if (acc != null) {
            System.out.println("Account balance: " + acc);
        }
    }

    public void displayAccount() {
        Account acc = selectAccount();
        if (acc == null) return;

        DisplayUtils.printAccountDetails(acc);
    }

    public void displayAllAccounts() {
        if (!hasAccounts()) return;
        DisplayUtils.printAllAccounts(accounts);
    }

    public void viewAccountTransactionHistory() {
        Account acc = selectAccount();
        if (acc == null) return;

        DisplayUtils.printTransactions(
                transactionService.getTransactionForAccount(acc.getAccountNumber())
        );
    }

    public void viewAllTransactions() {
        DisplayUtils.printTransactions(
                transactionService.getAllTransactions()
        );
    }

    public void deleteAccount() {
        Account acc = selectAccount();
        if (acc == null) return;

        System.out.print("Are you sure you want to delete? (yes/no): ");
        if (scan.next().equalsIgnoreCase("yes")) {
            accounts.remove(acc);
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Deletion cancelled");
        }
    }
}
