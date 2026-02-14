package com.tss.Structural.Decorator.PizzaShop;

public class Farmhouse implements Pizza {

    public String description() {
        return "Farmhouse Pizza";
    }

    public double cost() {
        return 250;
    }
}