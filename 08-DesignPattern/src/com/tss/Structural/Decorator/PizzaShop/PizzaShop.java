package com.tss.Structural.Decorator.PizzaShop;

public class PizzaShop {

    public static void main(String[] args) {

        Pizza pizza = new Margherita();

        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Mushroom(pizza);

        System.out.println(pizza.description());
        System.out.println("Total Cost: ₹" + pizza.cost());
    }
}