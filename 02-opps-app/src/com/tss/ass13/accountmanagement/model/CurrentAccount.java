package com.tss.ass13.accountmanagement.model;

import com.tss.ass13.accountmanagement.exception.MinimumBalaceException;
import com.tss.ass13.accountmanagement.exception.NagativeAmountException;

public class CurrentAccount extends Account {

    private static final double MIN_BALANCE = 500;

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NagativeAmountException(amount);
        }
        if (balance - amount < MIN_BALANCE) {
            throw new MinimumBalaceException(balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}