package com.tss.ass6;

public class SavingsAccount extends Account {

    private static final double offerRate = 8.0;

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            if (amount >= 50000) {
                double benefit = amount * (offerRate / 100);
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