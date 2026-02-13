package com.tss.Creational.Abstract.model;

public class MarutiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Maruti();
    }
}