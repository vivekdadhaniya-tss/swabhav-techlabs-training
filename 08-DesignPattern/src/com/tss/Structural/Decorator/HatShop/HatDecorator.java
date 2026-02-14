package com.tss.Structural.Decorator.HatShop;

public abstract class HatDecorator implements IHat {

    private IHat hat;

    public HatDecorator(IHat hat) {
        this.hat = hat;
    }

    @Override
    public String getName() {
        return hat.getName();
    }

    @Override
    public double getPrice() {
        return hat.getPrice();
    }

    @Override
    public String getDescription() {
        return hat.getDescription();
    }
}
