package com.tss.ass1.accountmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private static int idCounter = 0;
    private static int accountCounter = 10000;

    private final int id;
    private final int accountNumber;
    protected String name;
    protected double balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String name, double balance) {
        this.id = ++idCounter;
        this.name = name;
        this.balance = balance;
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

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public final void deposit(double amount) {
        deposit(amount, true);
    }

    public void deposit(double amount, boolean logTransaction) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        if(logTransaction) {
            addTransaction(new Transaction(
                    0,
                    this.accountNumber,
                    amount,
                    TransactionType.CREDIT
            ));
        }

        System.out.println("Deposit successful. Balance: " + balance);
    }
    public final boolean withdraw(double amount) {
        return withdraw(amount, true);
    }

    public abstract boolean withdraw(double amount, boolean logTransaction);
    public abstract AccountType getAccountType();
}
