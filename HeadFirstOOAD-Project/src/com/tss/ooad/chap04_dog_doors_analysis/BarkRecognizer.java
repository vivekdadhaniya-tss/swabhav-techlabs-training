package com.tss.ooad.chap04_dog_doors_analysis;

import java.util.Iterator;
import java.util.List;

public class BarkRecognizer {

    private DogDoor dogDoor;

    public BarkRecognizer(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void recognize(Bark bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");
        List<Bark> allowedBarks = dogDoor.getAllowedBarks();

        for (Bark allowedBark : allowedBarks) {
            if (allowedBark.equals(bark)) {
                dogDoor.open();
                return;
            }
        }
        System.out.println("This dog is not allowed.");
    }
}
