package com.tss.Structural.Decorator.PizzaShop;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String description() {
        return pizza.description();
    }

    public double cost() {
        return pizza.cost();
    }
}