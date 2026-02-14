package com.tss.Structural.Decorator.Garage;

public abstract class CarServiceDecorator implements ICarService {

    private ICarService carObj;

    public CarServiceDecorator(ICarService carObj) {
        this.carObj = carObj;
    }

    @Override
    public String getDescription() {
        return carObj.getDescription();
    }

    @Override
    public double getCost() {
        return carObj.getCost();
    }
}
