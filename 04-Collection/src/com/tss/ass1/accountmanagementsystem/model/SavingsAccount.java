package com.tss.ass1.accountmanagementsystem.model;

import static com.tss.ass1.accountmanagementsystem.util.AppConstants.SAVINGS_OFFER_LIMIT;
import static com.tss.ass1.accountmanagementsystem.util.AppConstants.SAVINGS_OFFER_RATE;

public class SavingsAccount extends Account {


    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void deposit(double amount, boolean logTransaction) {
        if (amount > 0) {
            balance += amount;

            if(logTransaction) {
                addTransaction(new Transaction(
                        0,
                        this.getAccountNumber(),
                        amount,
                        TransactionType.CREDIT
                ));
            }

            if (amount >= SAVINGS_OFFER_LIMIT) {
                double benefit = amount * (SAVINGS_OFFER_RATE / 100);
                balance += benefit;
            }

            System.out.println("Deposit successful. Balance: " + balance);
        }
    }

    @Override
    public boolean withdraw(double amount, boolean logTransaction) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;

            if (logTransaction) {
                addTransaction(new Transaction(
                        getAccountNumber(),
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
        return AccountType.SAVINGS;
    }
}