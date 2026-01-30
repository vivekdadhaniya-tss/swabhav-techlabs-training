package com.tss.ass13.accountmanagement.exception;

public class NagativeAmountException extends RuntimeException {

    private final double amount;

    public NagativeAmountException(double amount) {
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return "Invalid amount: " + amount + ". Amount must be greater than 0.";
    }
}
