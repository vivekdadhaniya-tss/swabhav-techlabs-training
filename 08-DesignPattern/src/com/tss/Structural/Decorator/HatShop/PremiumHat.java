package com.tss.Structural.Decorator.HatShop;

public class PremiumHat implements IHat {

    @Override
    public String getName() {
        return "Premium Hat";
    }

    @Override
    public double getPrice() {
        return 1000.0;
    }

    @Override
    public String getDescription() {
        return "A high-quality premium hat";
    }
}