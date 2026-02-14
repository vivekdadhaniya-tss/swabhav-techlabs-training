package com.tss.Structural.Decorator.HatShop;

public class StandardHat implements IHat {

    @Override
    public String getName() {
        return "Standard Hat";
    }

    @Override
    public double getPrice() {
        return 500.0;
    }

    @Override
    public String getDescription() {
        return "A simple standard hat";
    }
}