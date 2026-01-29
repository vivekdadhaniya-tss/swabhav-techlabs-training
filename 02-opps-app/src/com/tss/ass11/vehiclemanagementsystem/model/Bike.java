package com.tss.ass11.vehiclemanagementsystem.model;

public class Bike extends AbstractVehicle implements PetrolVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Bike fuel status: Petrol");
    }
}
