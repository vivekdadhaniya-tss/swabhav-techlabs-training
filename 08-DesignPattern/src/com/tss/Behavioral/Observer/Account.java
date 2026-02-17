package com.tss.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Long id;
    private String accountNo;
    private String name;
    private double balance;

    private List<Notifier> notifiers = new ArrayList<>();

    public Account(Long id, String accountNo, String name, double balance) {
        this.id = id;
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addNotifier(Notifier notifier) {
        notifiers.add(notifier);
    }

    public void removeNotifier(Notifier notifier) {
        notifiers.remove(notifier);
    }

    private void notifyAllObservers(String message) {
        for (Notifier notifier : notifiers) {
            notifier.update(this, message);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        notifyAllObservers("Deposit of " + amount + " successful.\nNew Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            notifyAllObservers("Withdrawal of " + amount + " failed due to insufficient balance.");
        } else {
            balance -= amount;
            notifyAllObservers("Withdrawal of " + amount + " successful.\nNew Balance: " + balance);
        }
    }
}