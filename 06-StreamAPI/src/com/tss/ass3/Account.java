package com.tss.ass3;

public class Account {
    private int accNo;
    private String name;
    private double amount;

    public Account(int accNo, String name, double amount) {
        this.accNo = accNo;
        this.name = name;
        this.amount = amount;
    }

    public int getAccNo() { return accNo; }
    public String getName() { return name; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "Account{" +
                "accNo=" + accNo +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
