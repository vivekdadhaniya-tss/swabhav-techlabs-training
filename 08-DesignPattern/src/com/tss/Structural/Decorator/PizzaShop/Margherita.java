package com.tss.Structural.Decorator.PizzaShop;

public class Margherita implements Pizza {

    public String description() {
        return "Margherita Pizza";
    }

    public double cost() {
        return 200;
    }
}
