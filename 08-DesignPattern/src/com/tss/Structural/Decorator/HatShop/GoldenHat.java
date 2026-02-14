package com.tss.Structural.Decorator.HatShop;

public class GoldenHat extends HatDecorator {

    public GoldenHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getName() {
        return super.getName() + " + Golden";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 200;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", decorated with gold";
    }
}
