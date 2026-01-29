package com.tss.ass11.vehiclemanagementsystem.model;

public class ElectricBike extends AbstractVehicle implements ElectricVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Electric bike battery status available");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Electric bike battery charging...");
    }
}
