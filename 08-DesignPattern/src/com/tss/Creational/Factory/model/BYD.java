package com.tss.Creational.Factory.model;

import com.tss.Creational.Factory.model.Car;

public class BYD implements Car {

    @Override
    public void drive() {
        System.out.println("Driving BYD");
    }
}
