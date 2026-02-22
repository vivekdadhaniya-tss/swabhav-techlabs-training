package com.tss.ooad.chap02_dog_doors;

public class DogDoorSimulator {

    public static void main(String[] args) {

        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);

        System.out.println("Fido barks to go outside...");
        remote.pressButton();

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        // Simulate Fido staying outside for 10 seconds (10000 ms)
        // The door is programmed to close after 5 seconds, so it will close while he is out.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) { }

        System.out.println("...but he's stuck outside!");

        // The Alternate Path: Fido barks, and Gina uses the remote again
        System.out.println("\nFido starts barking...");
        System.out.println("...so Gina grabs the remote control.");
        remote.pressButton();

        System.out.println("\nFido's back inside...");
    }
}