package com.tss.Behavioral.Strategy;

import java.util.Set;

public class ManagerRole implements Role {

    private final Set<String> resources =
            Set.of("CODE_REPO", "REPORTS", "FINANCE_SYSTEM");

    private final double approvalLimit = 10000;

    @Override
    public String getRoleName() {
        return "MANAGER";
    }

    @Override
    public void performDuties() {
        System.out.println("Managing team...");
    }

    @Override
    public boolean canAccess(String resource) {
        return resources.contains(resource);
    }

    @Override
    public boolean canApprove(double amount) {
        return amount <= approvalLimit;
    }
}