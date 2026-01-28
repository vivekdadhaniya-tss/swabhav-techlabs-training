package com.tss.ass7.model;

import static com.tss.ass7.util.AppConstants.SAVINGS_OFFER_LIMIT;
import static com.tss.ass7.util.AppConstants.SAVINGS_OFFER_RATE;

public class SavingsAccount extends Account {


    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            if (amount >= SAVINGS_OFFER_LIMIT) {
                double benefit = amount * (SAVINGS_OFFER_RATE / 100);
                balance += benefit;
            }

            System.out.println("Deposit successful. Balance: " + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("Withdrawal cancelled: insufficient balance.");
        }
    }
}