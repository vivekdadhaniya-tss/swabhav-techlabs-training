package com.tss.ass13.accountmanagement.exception;

public class InsufficientBalanceException extends RuntimeException {

    private final double balance;

    public InsufficientBalanceException(double balance) {
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "Insufficient balance. Current balance: " + balance;
    }
}
