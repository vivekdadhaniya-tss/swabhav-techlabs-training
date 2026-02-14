package com.tss.Structural.Decorator.Garage;

public class OilChange extends CarServiceDecorator{

    public OilChange(ICarService carObj) {
        super(carObj);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", OilChange";
    }

    @Override
    public double getCost() {
        return super.getCost() + 500;
    }
}
