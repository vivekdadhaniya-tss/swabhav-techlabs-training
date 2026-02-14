package com.tss.Structural.Decorator.PizzaShop;

public class Cheese extends PizzaDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String description() {
        return super.description() + ", Extra Cheese";
    }

    public double cost() {
        return super.cost() + 40;
    }
}