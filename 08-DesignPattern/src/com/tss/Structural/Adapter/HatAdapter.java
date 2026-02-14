package com.tss.Structural.Adapter;

public class HatAdapter implements IItem{

    private Hat hat;

    public HatAdapter(Hat hat){
        this.hat = hat;
    }

    @Override
    public String getItemName() {
        return hat.getShortName();
    }

    @Override
    public Double getItemPrice() {
        return hat.getPriceWithTax();
    }
}
