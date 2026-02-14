package com.tss.Structural.Adapter;

public class Biscuit implements IItem {

    private String name;
    private double mrp;

    public Biscuit(String name, double mrp) {
        this.name = name;
        this.mrp = mrp;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public Double getItemPrice() {
        return mrp;
    }
}
