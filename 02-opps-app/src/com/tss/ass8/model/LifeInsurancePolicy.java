package com.tss.ass8.model;

import com.tss.ass8.util.PolicyConstants;

public class LifeInsurancePolicy extends InsurancePolicy {

    private boolean matured;

    public LifeInsurancePolicy(String policyHolderName,
                               double sumAssured,
                               int policyDuration) {
        super(policyHolderName, sumAssured, policyDuration);
        this.matured = false;
    }

    public void maturePolicy() {
        this.matured = true;
    }

    public boolean isMatured() {
        return matured;
    }

    @Override
    public double calculatePremium() {
        return sumAssured * PolicyConstants.LIFE_PREMIUM_RATE;
    }

    @Override
    public void applyClaim(double claimAmount) {

        if (!active || !matured) {
            System.out.println("Claim denied.");
            return;
        }

        System.out.println("Life claim approved.");
        System.out.println("Paid: " + remainingSumAssured);

        remainingSumAssured = 0;
        deactivatePolicy();
    }
}
