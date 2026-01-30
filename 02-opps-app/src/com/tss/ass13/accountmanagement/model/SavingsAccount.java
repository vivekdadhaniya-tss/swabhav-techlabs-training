package com.tss.ass13.accountmanagement.model;

import com.tss.ass13.accountmanagement.exception.InsufficientBalanceException;
import com.tss.ass13.accountmanagement.exception.NagativeAmountException;

public class SavingsAccount extends Account {

    private static final double offerRate = 8.0;

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NagativeAmountException(amount);
        }
        balance += amount;
        if (amount >= 50000) {
            double benefit = amount * (offerRate / 100);
            balance += benefit;
        }
        System.out.println("Deposit successful. Balance: " + balance);

    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NagativeAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}