package com.tss.ass2.accountmanagementsystem.model;

import static com.tss.ass1.accountmanagementsystem.util.AppConstants.CURRENT_MIN_BALANCE;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        if (balance - amount >= CURRENT_MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CURRENT;
    }
}