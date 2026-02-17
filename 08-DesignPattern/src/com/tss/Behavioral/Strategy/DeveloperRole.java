package com.tss.Behavioral.Strategy;

import java.util.Set;

public class DeveloperRole implements Role {

    private final Set<String> resources = Set.of("CODE_REPO", "DEV_SERVER");

    @Override
    public String getRoleName() {
        return "DEVELOPER";
    }

    @Override
    public void performDuties() {
        System.out.println("Writing code and fixing bugs.");
    }

    @Override
    public boolean canAccess(String resource) {
        return resources.contains(resource);
    }

    @Override
    public boolean canApprove(double amount) {
        return false;
    }
}