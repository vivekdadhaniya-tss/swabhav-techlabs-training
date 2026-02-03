package com.tss.ass2.accountmanagementsystem.model;

public abstract class Account {

    private static int idCounter = 0;
    private static int accountCounter = 10000;

    private final int id;
    private final int accountNumber;
    protected String name;
    protected double balance;

    public Account(String name, double balance) {
        this.id = ++idCounter;
        this.name = name;
        this.balance = balance;
        this.accountNumber = ++accountCounter;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. Balance: " + balance);
    }

    public abstract boolean withdraw(double amount);
    public abstract AccountType getAccountType();
}
