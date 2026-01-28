package com.tss.ass8.menu;

import com.tss.ass8.model.InsurancePolicy;
import com.tss.ass8.model.LifeInsurancePolicy;
import com.tss.ass8.service.PolicyService;
import com.tss.ass8.util.InputValidator;
import com.tss.ass8.util.PolicyType;

import java.util.Scanner;

public class PolicyMenu {

    private PolicyService policyService;
    private final Scanner scanner;

    public PolicyMenu() {
        policyService = new PolicyService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("""
                
                ===== Insurance Policy Management System =====
                1. Create Policy
                2. Calculate Premium
                3. Apply Claim
                4. Display Policy Details
                5. Mature Life Policy
                6. Exit
                """);

            choice = InputValidator.readInt(scanner, "Choose option: ");
            scanner.nextLine();

            switch (choice) {
                case 1 -> createPolicy();
                case 2 -> calculatePremium();
                case 3 -> applyClaim();
                case 4 -> displayPolicy();
                case 5 -> matureLifePolicy();
                case 6 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private boolean checkPolicyExists() {
        if (!policyService.hasPolicies()) {
            System.out.println("Please create a policy first.");
            return false;
        }
        return true;
    }

    private void createPolicy() {

        System.out.print("""
        
                    Select Policy Type:
                    1. Life Insurance
                    2. Health Insurance
                    3. Vehicle Insurance 
                    """);

        System.out.print("Choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        PolicyType policyType = switch (typeChoice) {
            case 1 -> PolicyType.LIFE;
            case 2 -> PolicyType.HEALTH;
            case 3 -> PolicyType.VEHICLE;
            default -> {
                System.out.println("Invalid policy type!");
                yield null;
            }
        };

        if (policyType == null) return;

        String name = InputValidator.readName(scanner, "Enter Policy Holder Name: ");
        double sumAssured = InputValidator.readDouble(scanner, "Enter Sum Assured: ");

        if (InputValidator.isValidAmount(sumAssured)) {
            System.out.println("Amount must be greater than 0.");
            return;
        }

        int duration = InputValidator.readInt(scanner, "Enter Policy Duration (years): ");

        if (!InputValidator.isValidDuration(duration)) {
            System.out.println("Policy duration must be between 0 and 50 years.");
            return;
        }

        InsurancePolicy policy = policyService.createPolicy(policyType, name, sumAssured, duration);

        if (policy != null) {
            System.out.println("Policy created successfully!");
            System.out.println("Policy Number: " + policy.getPolicyNumber());
        }
    }

    private void calculatePremium() {

        if (!checkPolicyExists()) return;

        policyService.selectPolicy();

        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();

        double premium = policyService.calculatePremium(policyNumber);

        if (premium >= 0) {
            System.out.println("Annual Premium: " + premium);
        } else {
            System.out.println("Policy not found!");
        }
    }

    private void applyClaim() {

        if (!checkPolicyExists()) return;

        policyService.selectPolicy();

        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();

        InsurancePolicy policy =
                policyService.getPolicyDetails(policyNumber);

        if (policy == null) {
            System.out.println("Policy not found!");
            return;
        }

        if (policy instanceof LifeInsurancePolicy) {
            System.out.println("Life insurance pays full amount on maturity.");
            policyService.applyClaim(policyNumber, 0);
            return;
        }

        double claimAmount = InputValidator.readDouble(scanner, "Enter Claim Amount: ");

        if (InputValidator.isValidAmount(claimAmount)) {
            System.out.println("Invalid claim amount.");
            return;
        }


        boolean success = policyService.applyClaim(policyNumber, claimAmount);

        if (!success) {
            System.out.println("Policy not found!");
        }
    }

    private void matureLifePolicy() {

        if (!checkPolicyExists()) return;

        boolean hasLifePolicies = policyService.selectLifePolicies();

        if (!hasLifePolicies) {
            return;
        }

        System.out.print("Enter Policy Number to mature: ");
        int policyNumber = scanner.nextInt();

        boolean success = policyService.matureLifePolicy(policyNumber);

        if (success) {
            System.out.println("Life policy matured successfully.");
        } else {
            System.out.println("Invalid policy or not a Life Insurance policy.");
        }
    }

    private void displayPolicy() {

        if (!checkPolicyExists()) return;

        policyService.selectPolicy();

        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();

        InsurancePolicy policy =
                policyService.getPolicyDetails(policyNumber);

        if (policy == null) {
            System.out.println("Policy not found!");
            return;
        }

        System.out.println("""
        
        Policy Number : %d
        Policy Holder : %s
        Sum Assured   : %.2f
        Remaining     : %.2f
        Duration      : %d years
        Active        : %b
        """.formatted(
                policy.getPolicyNumber(),
                policy.getPolicyHolderName(),
                policy.getSumAssured(),
                policy.getRemainingSumAssured(),
                policy.getPolicyDuration(),
                policy.isActive()
        ));
    }
}
