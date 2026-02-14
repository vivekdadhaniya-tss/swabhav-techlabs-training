package com.tss.Structural.Adapter;

public class Hat {

    private String shortName;
    private String longName;
    private double basePrice;
    private double tax;

    public Hat(String shortName, String longName, double basePrice, double tax) {
        this.shortName = shortName;
        this.longName = longName;
        this.basePrice = basePrice;
        this.tax = tax;
    }

    public String getShortName() {
        return shortName;
    }

    public double getPriceWithTax() {
        return basePrice + tax;
    }
}
