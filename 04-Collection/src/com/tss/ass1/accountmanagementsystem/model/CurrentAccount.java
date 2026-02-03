package com.tss.ass1.accountmanagementsystem.model;

import static com.tss.ass1.accountmanagementsystem.util.AppConstants.CURRENT_MIN_BALANCE;

public class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public boolean withdraw(double amount, boolean logTransaction) {
        if (amount <= 0) return false;

        if (balance - amount >= CURRENT_MIN_BALANCE) {
            balance -= amount;

            if(logTransaction) {
                addTransaction(new Transaction(
                        this.getAccountNumber(),
                        0,
                        amount,
                        TransactionType.DEBIT
                ));
            }
            return true;
        }
        return false;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CURRENT;
    }
}