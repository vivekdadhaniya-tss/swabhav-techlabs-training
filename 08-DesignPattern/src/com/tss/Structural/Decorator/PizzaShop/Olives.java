package com.tss.Structural.Decorator.PizzaShop;

public class Olives extends PizzaDecorator {

    public Olives(Pizza pizza) {
        super(pizza);
    }

    public String description() {
        return super.description() + ", Olives";
    }

    public double cost() {
        return super.cost() + 30;
    }
}