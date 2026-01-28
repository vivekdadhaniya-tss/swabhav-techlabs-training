package com.tss.ass6;

public class CurrentAccount extends Account {

    private static final double MIN_BALANCE = 500;

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;

        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        } else {
            System.out.println("Withdrawal canceled. Minimum balance 500 rs. required.");
        }
    }
}