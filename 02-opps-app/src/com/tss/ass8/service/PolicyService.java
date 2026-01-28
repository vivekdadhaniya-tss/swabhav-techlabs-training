package com.tss.ass8.service;

import com.tss.ass8.model.*;
import com.tss.ass8.util.PolicyConstants;
import com.tss.ass8.util.PolicyType;

public class PolicyService {

    private final InsurancePolicy[] policies;
    private int policyCount;

    public PolicyService() {
        policies = new InsurancePolicy[PolicyConstants.MAX_POLICIES];
        policyCount = 0;
    }

    public boolean hasPolicies() {
        return policyCount > 0;
    }

    public InsurancePolicy createPolicy(PolicyType type,
                                        String policyHolderName,
                                        double sumAssured,
                                        int policyDuration) {

        if (policyCount >= policies.length) {
            System.out.println("Cannot create policy: Storage is full.");
            return null;
        }

        InsurancePolicy policy = switch (type) {
            case LIFE -> new LifeInsurancePolicy(
                    policyHolderName, sumAssured, policyDuration);

            case HEALTH -> new HealthInsurancePolicy(
                    policyHolderName, sumAssured, policyDuration);

            case VEHICLE -> new VehicleInsurancePolicy(
                    policyHolderName, sumAssured, policyDuration);
        };

        policies[policyCount++] = policy;
        return policy;
    }

    public InsurancePolicy findPolicyByNumber(int policyNumber) {
        for (int i = 0; i < policyCount; i++) {
            if (policies[i].getPolicyNumber() == policyNumber) {
                return policies[i];
            }
        }
        return null;
    }

    public double calculatePremium(int policyNumber) {
        InsurancePolicy policy = findPolicyByNumber(policyNumber);
        if (policy != null) {
            return policy.calculatePremium();
        }
        return -1;
    }

    public boolean applyClaim(int policyNumber, double claimAmount) {
        InsurancePolicy policy = findPolicyByNumber(policyNumber);
        if (policy != null) {
            policy.applyClaim(claimAmount);
            return true;
        }
        return false;
    }

    public InsurancePolicy getPolicyDetails(int policyNumber) {
        return findPolicyByNumber(policyNumber);
    }

    public boolean matureLifePolicy(int policyNumber) {
        InsurancePolicy policy = findPolicyByNumber(policyNumber);
        if (policy instanceof LifeInsurancePolicy) {
            ((LifeInsurancePolicy) policy).maturePolicy();
            return true;
        }
        return false;
    }

    public void selectPolicy() {

        if (policyCount == 0) {
            System.out.println("No policies available.");
            return;
        }

        System.out.println("\nSelect a Policy:");
        System.out.println("-------------------------");

        for (int i = 0; i < policyCount; i++) {
            InsurancePolicy p = policies[i];
            System.out.println(
                    "Policy No: " + p.getPolicyNumber() +
                            " | Holder: " + p.getPolicyHolderName()
            );
        }

        System.out.println("-------------------------");
    }

    public boolean selectLifePolicies() {

        boolean found = false;

        System.out.println("\nLife Insurance Policies:");
        System.out.println("-------------------------");

        for (int i = 0; i < policyCount; i++) {
            InsurancePolicy p = policies[i];

            if (p instanceof LifeInsurancePolicy) {
                System.out.println(
                        "Policy No: " + p.getPolicyNumber() +
                                " | Holder: " + p.getPolicyHolderName()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No life insurance policies found.");
        }

        System.out.println("-------------------------");
        return found;
    }


}
