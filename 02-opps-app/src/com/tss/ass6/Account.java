package com.tss.ass6;

public abstract class Account {

    private static int idCounter = 0;
    private static int accountCounter = 1000;

    private final int id;
    private final int accountNumber;
    protected String name;
    protected double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;

        this.id = ++idCounter;
        this.accountNumber = ++accountCounter;
    }

    public int getId() {
        return id;
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
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);
}
