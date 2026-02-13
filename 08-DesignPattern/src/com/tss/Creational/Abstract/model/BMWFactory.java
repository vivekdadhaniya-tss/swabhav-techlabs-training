package com.tss.Creational.Abstract.model;

import com.tss.Creational.Singleton.DatabaseConnection;

public class BMWFactory implements CarFactory {

    public BMWFactory() {}

    private static class Holder {
        private static final BMWFactory INSTANCE = new BMWFactory();
    }

    public static BMWFactory getInstance() {
        return Holder.INSTANCE;
    }
    @Override
    public Car createCar() {
        return new BMW();
    }
}
