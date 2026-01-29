package com.tss.ass11.vehiclemanagementsystem.model;

public class Car extends AbstractVehicle implements PetrolVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Car fuel status: Petrol");
    }
}
