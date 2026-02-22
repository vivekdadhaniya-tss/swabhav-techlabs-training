package com.tss.ooad.chap01_ricks_guitars;

import java.util.Arrays;
import java.util.List;

public class FindGuitarTester {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(
                Builder.FENDER,
                "Stratocaster",
                Type.ELECTRIC,
                Wood.ALDER,
                Wood.ALDER,
                6
        );

        List<Guitar> matchingGuitars  = inventory.search(whatErinLikes);

        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:\n");

            for (Guitar guitar : matchingGuitars) {
                System.out.println(guitar);
            }

        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V95693", 1499.95,
                new GuitarSpec(Builder.FENDER, "Stratocaster",
                        Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        inventory.addGuitar("V9512", 1549.95,
                new GuitarSpec(Builder.FENDER, "Stratocaster",
                        Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        inventory.addGuitar("A12345", 999.99,
                new GuitarSpec(Builder.GIBSON, "Les Paul",
                        Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE, 6));

        inventory.addGuitar("M76543", 1999.99,
                new GuitarSpec(Builder.MARTIN, "D-28",
                        Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA, 6));
    }
}