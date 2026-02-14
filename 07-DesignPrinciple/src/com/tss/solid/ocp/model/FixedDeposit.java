package com.tss.solid.ocp.model;

public class FixedDeposit {

    private static int accNoCounter = 1000;
    private int accNo;
    private String name;
    private double principal;
    private int duration;
    private InterestRate interestRate;

    public FixedDeposit(String name,
                        double principal, int duration,
                        InterestRate interestRate) {

        this.accNo = ++accNoCounter;
        this.name = name;
        this.principal = principal;
        this.duration = duration;
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return principal * interestRate.getRate() * duration;
    }

    public double calculateTotalAmount() {
        return principal + calculateInterest();
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getPrincipal() {
        return principal;
    }

    public int getDuration() {
        return duration;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }
}
