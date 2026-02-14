package com.tss.Structural.Adapter;

import java.util.List;

public class ShoppingCart {

    private List<IItem> items;

    public ShoppingCart(List<IItem> items) {
        this.items = items;
    }

    public List<IItem> getCartItems() {
        return items;
    }

    public double getCartPrice() {
        double totalPrice = 0;
        for (IItem item : items) {
            totalPrice += item.getItemPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        System.out.printf("%-15s %8s%n", "Item Name", "Price");
        System.out.println("----------------------------");

        for (IItem item : items) {
            System.out.printf("%-15s %8.2f%n",
                    item.getItemName(),
                    item.getItemPrice());
        }

        System.out.println("----------------------------");
        System.out.printf("%-15s %8.2f%n", "Total:", getCartPrice());
    }
}
