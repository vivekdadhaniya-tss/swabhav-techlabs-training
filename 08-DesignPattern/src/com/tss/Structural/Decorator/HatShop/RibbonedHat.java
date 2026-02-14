package com.tss.Structural.Decorator.HatShop;

public class RibbonedHat extends HatDecorator {

    public RibbonedHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getName() {
        return super.getName() + " + Ribbon";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 100;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", decorated with ribbon";
    }
}
