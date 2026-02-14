package com.tss.Structural.Decorator.PizzaShop;

public class Mushroom extends PizzaDecorator {

    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    public String description() {
        return super.description() + ", Mushroom";
    }

    public double cost() {
        return super.cost() + 50;
    }
}