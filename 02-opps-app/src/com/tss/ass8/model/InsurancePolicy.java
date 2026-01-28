package com.tss.ass8.model;

import com.tss.ass8.util.PolicyConstants;

public abstract class InsurancePolicy {

    private static int policyCounter = PolicyConstants.POLICY_NUMBER_START;
    protected final int policyNumber;
    protected final String policyHolderName;
    protected double sumAssured;
    protected double remainingSumAssured;
    protected int policyDuration;
    protected boolean active;

    public InsurancePolicy(String policyHolderName,
                           double sumAssured,
                           int policyDuration) {

        this.policyNumber = ++policyCounter;
        this.policyHolderName = policyHolderName;
        this.sumAssured = sumAssured;
        this.remainingSumAssured = sumAssured;
        this.policyDuration = policyDuration;
        this.active = true;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public double getSumAssured() {
        return sumAssured;
    }

    public double getRemainingSumAssured() { return remainingSumAssured; }

    public int getPolicyDuration() {
        return policyDuration;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivatePolicy() {
        this.active = false;
    }

    public abstract double calculatePremium();
    public abstract void applyClaim(double claimAmount);

}
