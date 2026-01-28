package com.tss.ass7.model;

import static com.tss.ass7.util.AppConstants.CURRENT_MIN_BALANCE;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        if (balance - amount >= CURRENT_MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("Withdrawal canceled. Minimum balance 500 rs. required.");
        }
    }
}