package com.tss.ooad.chap03_dog_doors_updated;

public class DogDoorSimulator {

    public static void main(String[] args) {

        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        System.out.println("Fido barks to go outside...");
//        recognizer.recognize("Woof");
//        remote.pressButton();

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) { }

        System.out.println("...but he's stuck outside!");

        // Simulate the hardware hearing a bark again
        System.out.println("Fido starts barking.");
//        recognizer.recognize("Woof");

        System.out.println("\nFido's back inside...");
    }
}