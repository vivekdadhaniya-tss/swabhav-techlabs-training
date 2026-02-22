package com.tss.ooad.chap05_part2_cohesive;

import com.tss.ooad.chap05_part2_cohesive.type.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindGuitarTester {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        // Create a map of properties Erin likes
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("instrumentType", InstrumentType.GUITAR);
//        properties.put("builder", Builder.FENDER);
//        properties.put("model", "Stratocaster");
//        properties.put("type", Type.ELECTRIC);
//        properties.put("backWood", Wood.ALDER);
//        properties.put("topWood", Wood.ALDER);
//        properties.put("numStrings", 6);

        Map<String, Object> properties = new HashMap<>();
        properties.put("type", Type.ELECTRIC);

        InstrumentSpec whatErinLikes = new InstrumentSpec(properties);

        List<Instrument> matchingInstruments  = inventory.search(whatErinLikes);

        if (matchingInstruments.isEmpty()) {
            System.out.println("Sorry, Erin, we have nothing matching your request.");
            return;
        }

        System.out.println("Erin, you might like these instruments:\n");

        for (Instrument instrument : matchingInstruments) {
            System.out.println(instrument);   // uses toString()
        }

    }

    private static void initializeInventory(Inventory inventory) {
        Map<String, Object> props1 = new HashMap<>();
        props1.put("instrumentType", InstrumentType.GUITAR);
        props1.put("builder", Builder.FENDER);
        props1.put("model", "Stratocaster");
        props1.put("type", Type.ELECTRIC);
        props1.put("backWood", Wood.ALDER);
        props1.put("topWood", Wood.ALDER);
        props1.put("numStrings", 6);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(props1));

        Map<String, Object> props2 = new HashMap<>();
        props2.put("instrumentType", InstrumentType.GUITAR);
        props2.put("builder", Builder.FENDER);
        props2.put("model", "Stratocaster");
        props2.put("type", Type.ELECTRIC);
        props2.put("backWood", Wood.ALDER);
        props2.put("topWood", Wood.ALDER);
        props2.put("numStrings", 6);
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(props2));

        Map<String, Object> props3 = new HashMap<>();
        props3.put("instrumentType", InstrumentType.MANDOLIN);
        props3.put("builder", Builder.GIBSON);
        props3.put("model", "Les Paul");
        props3.put("type", Type.ELECTRIC);
        props3.put("style", Style.A);
        props3.put("backWood", Wood.MAPLE);
        props3.put("topWood", Wood.MAPLE);
        inventory.addInstrument("A12345", 999.99, new InstrumentSpec(props3));

        Map<String, Object> props4 = new HashMap<>();
        props4.put("instrumentType", InstrumentType.BANJO);
        props4.put("builder", Builder.MARTIN);
        props4.put("model", "D-28");
        props4.put("type", Type.ACOUSTIC);
        props4.put("backWood", Wood.INDIAN_ROSEWOOD);
        props4.put("topWood", Wood.SITKA);
        props4.put("numStrings", 5);
        inventory.addInstrument("M76543", 1999.99, new InstrumentSpec(props4));
    }
}