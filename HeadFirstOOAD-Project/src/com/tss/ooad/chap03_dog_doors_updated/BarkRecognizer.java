package com.tss.ooad.chap03_dog_doors_updated;

public class BarkRecognizer {

    private DogDoor dogDoor;

    public BarkRecognizer(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void recognize(Bark bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark + "'");
        if(dogDoor.getAllowedBark().equals(bark)) {
            dogDoor.open();
        } else {
            System.out.println("This dog is " + "not allowed.");
        }
    }
}
