package com.tss.srp.model;

public class Invoice {

    private static int idCounter = 100;
    private int id;
    private String description;
    private double amount;
    private double taxPercentage;

    public Invoice(String description, double amount, double taxPercentage) {
        this.id = ++idCounter;
        this.description = description;
        this.amount = amount;
        this.taxPercentage = taxPercentage;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public double getAmount() {
        return amount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

}
