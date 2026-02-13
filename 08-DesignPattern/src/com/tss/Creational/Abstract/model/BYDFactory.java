package com.tss.Creational.Abstract.model;

public class BYDFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new BYD();
    }
}