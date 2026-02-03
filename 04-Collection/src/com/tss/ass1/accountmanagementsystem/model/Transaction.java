package com.tss.ass1.accountmanagementsystem.model;

import java.time.LocalDateTime;

public class Transaction {

    private static int counter = 2000;

    private final int transactionId;
    private final int fromAccount;
    private final int toAccount;
    private final double amount;
    private final TransactionType type;
    private final LocalDateTime timestamp;

    public Transaction(int fromAccount, int toAccount, double amount, TransactionType type) {
        this.transactionId = ++counter;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", ammount=" + amount +
                ", type=" + type +
                ", timestamp=" + timestamp +
                '}';
    }
}
