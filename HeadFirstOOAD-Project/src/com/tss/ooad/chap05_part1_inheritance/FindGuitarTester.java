package com.tss.ooad.chap05_part1_inheritance;

import com.tss.ooad.chap05_part1_inheritance.type.Builder;
import com.tss.ooad.chap05_part1_inheritance.type.Type;
import com.tss.ooad.chap05_part1_inheritance.type.Wood;

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
        inventory.addInstrument("V95693", 1499.95,
                new GuitarSpec(Builder.FENDER, "Stratocaster",
                        Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        inventory.addInstrument("V9512", 1549.95,
                new GuitarSpec(Builder.FENDER, "Stratocaster",
                        Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        inventory.addInstrument("A12345", 999.99,
                new GuitarSpec(Builder.GIBSON, "Les Paul",
                        Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE, 6));

        inventory.addInstrument("M76543", 1999.99,
                new GuitarSpec(Builder.MARTIN, "D-28",
                        Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA, 6));
    }
}