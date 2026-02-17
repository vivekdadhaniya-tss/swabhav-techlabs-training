package com.tss;

public class BankAccount {

    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}