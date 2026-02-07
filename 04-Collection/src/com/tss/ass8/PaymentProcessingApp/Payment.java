package com.tss.ass8.PaymentProcessingApp;

@FunctionalInterface
public interface Payment {
    boolean pay(double amount);
}
