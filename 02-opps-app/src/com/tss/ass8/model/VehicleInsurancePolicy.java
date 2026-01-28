package com.tss.ass8.model;

import com.tss.ass8.util.PolicyConstants;

public class VehicleInsurancePolicy extends InsurancePolicy {

    public VehicleInsurancePolicy(String policyHolderName,
                                  double sumAssured,
                                  int policyDuration) {
        super(policyHolderName, sumAssured, policyDuration);
    }

    @Override
    public double calculatePremium() {
        return sumAssured * PolicyConstants.VEHICLE_PREMIUM_RATE;
    }

    @Override
    public void applyClaim(double claimAmount) {

        if (!active) {
            System.out.println("Policy inactive.");
            return;
        }

        if (claimAmount > remainingSumAssured) {
            System.out.println("Claim denied: Amount exceeds sum assured.");
            return;
        }

        if (claimAmount <= 0) {
            System.out.println("Invalid claim amount.");
            return;
        }

        remainingSumAssured -= claimAmount;

        System.out.println("Vehicle claim approved.");
        System.out.println("Claimed: " + claimAmount);

        if (remainingSumAssured == 0) {
            deactivatePolicy();
            System.out.println("Policy closed: Coverage exhausted.");
        }
    }

}
