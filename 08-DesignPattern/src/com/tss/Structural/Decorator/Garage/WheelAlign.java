package com.tss.Structural.Decorator.Garage;

public class WheelAlign extends CarServiceDecorator {

    public WheelAlign(ICarService carObj) {
        super(carObj);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Wheel Align";
    }

    @Override
    public double getCost() {
        return super.getCost() + 400;
    }
}
