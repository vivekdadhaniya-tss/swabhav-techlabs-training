package com.tss.solid.ocp.model;

public class NewYearInterest implements InterestRate {

    @Override
    public double getRate() {
        return 0.06;
    }
}
