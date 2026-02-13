package com.tss.Creational.Factory.model;

public class CarFactory {
    public static Car getCar(String type) {

        if (type == null) {
            System.out.println("Car type cannot be null");
            return null;
        }

        switch (type.toUpperCase()) {
            case "BMW":
                return new BMW();

            case "AUDI":
                return new BYD();

            case "TESLA":
                return new Maruti();

            default:
                System.out.println("Invalid car type");
        }
        return null;
    }
}
