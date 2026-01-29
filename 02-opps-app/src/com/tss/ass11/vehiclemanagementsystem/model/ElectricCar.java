package com.tss.ass11.vehiclemanagementsystem.model;

public class ElectricCar extends AbstractVehicle implements ElectricVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Electric car battery status available");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Electric car battery charging...");
    }
}
