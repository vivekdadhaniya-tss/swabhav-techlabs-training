package com.tss.Structural.Decorator.Garage;

public class CarInspection implements ICarService {
    @Override
    public String getDescription() {
        return "Car Inception";
    }

    @Override
    public double getCost() {
        return 1000;
    }
}
