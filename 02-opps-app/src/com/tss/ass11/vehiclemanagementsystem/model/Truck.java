package com.tss.ass11.vehiclemanagementsystem.model;

public class Truck extends AbstractVehicle implements PetrolVehicle {

    @Override
    public void getFuelStatus() {
        System.out.println("Truck fuel status: Petrol");
    }

    @Override
    public void horn() {
        System.out.println("Truck horn: HONK HONK");
    }
}
