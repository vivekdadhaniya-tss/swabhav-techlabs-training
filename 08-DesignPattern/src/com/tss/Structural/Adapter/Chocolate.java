package com.tss.Structural.Adapter;

public class Chocolate implements IItem {

    private String name;
    private double mrp;

    public Chocolate(String name, double mrp) {
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
