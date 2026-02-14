package com.tss.Structural.Decorator.Garage;

public class GarageShop {

    public static void main(String[] args) {

        // Service 1: Inspection + Oil Change + Wheel Alignment
        ICarService service = new CarInspection();
        service = new OilChange(service);
        service = new WheelAlign(service);

        System.out.println("Service 1:");
        System.out.println(service.getDescription());
        System.out.println("Total Cost: " + service.getCost());

        // Service 2: Inspection + Wheel Alignment only
        ICarService service2 = new WheelAlign(new CarInspection());

        System.out.println("\nService 2:");
        System.out.println(service2.getDescription());
        System.out.println("Total Cost: " + service2.getCost());
    }
}