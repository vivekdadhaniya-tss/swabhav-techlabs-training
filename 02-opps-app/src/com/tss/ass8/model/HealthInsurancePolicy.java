package com.tss.ass8.model;

import com.tss.ass8.util.PolicyConstants;

public class HealthInsurancePolicy extends InsurancePolicy {

    public HealthInsurancePolicy(String policyHolderName,
                                 double sumAssured,
                                 int policyDuration) {
        super(policyHolderName, sumAssured, policyDuration);
    }

    @Override
    public double calculatePremium() {
        return sumAssured * PolicyConstants.HEALTH_PREMIUM_RATE;
    }

    @Override
    public void applyClaim(double claimAmount) {

        if (!active) {
            System.out.println("Policy inactive.");
            return;
        }

        if (claimAmount > remainingSumAssured) {
            System.out.println("Claim denied: Amount exceeds remaining coverage.");
            return;
        }

        if (claimAmount <= 0) {
            System.out.println("Invalid claim amount.");
            return;
        }

        remainingSumAssured -= claimAmount;

        System.out.println("Health claim approved.");
        System.out.println("Claimed: " + claimAmount);
        System.out.println("Remaining coverage: " + remainingSumAssured);

        if (remainingSumAssured == 0) {
            deactivatePolicy();
            System.out.println("Policy closed: Coverage exhausted.");
        }

    }
}