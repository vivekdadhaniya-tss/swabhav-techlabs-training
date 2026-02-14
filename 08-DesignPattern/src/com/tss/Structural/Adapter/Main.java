package com.tss.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IItem> items = new ArrayList<>();

        IItem biscuit = new Biscuit("Parle G",10);
        IItem chocolate = new Chocolate("Dairy Milk",20);

        Hat hat = new Hat("Hat", "Summer Hat", 50 ,7);
        IItem hatAdapter = new HatAdapter(hat);

        items.add(biscuit);
        items.add(chocolate);
        items.add(hatAdapter);

        ShoppingCart cart = new ShoppingCart(items);
        cart.displayCart();
    }
}
