package com.tss.ass11.vehiclemanagementsystem.model;

public interface Vehicle {

    int getId();

    void start();

    void stop();

    String getStatus();

    void getFuelStatus();

    default void horn() {
        System.out.println("Horn sound");
    }

    default void playMusic() {
        System.out.println("Playing music");
    }

    static void vehicleInspection() {
        System.out.println("General vehicle inspection done");
    }
}
