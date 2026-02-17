package com.tss.Behavioral.Strategy;

public interface Role {
    void performDuties();

    boolean canApprove(double amount);

    boolean canAccess(String resource);

    String getRoleName();
}
