package com.tss.ass13.accountmanagement.exception;

public class MinimumBalaceException extends RuntimeException {

    private final double balance;

    public MinimumBalaceException(double balance) {
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "Withdrawal cancelled. Minimum balance of 500 required. Current balance: " + balance;
    }
}
