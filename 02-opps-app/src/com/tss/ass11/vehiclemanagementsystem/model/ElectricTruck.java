package com.tss.ass11.vehiclemanagementsystem.model;

public class ElectricTruck extends AbstractVehicle implements ElectricVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Electric truck battery status available");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Electric truck battery charging...");
    }

}
