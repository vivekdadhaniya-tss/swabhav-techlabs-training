package com.tss.ass10;

public abstract class EnterpriseResource {


    protected final String resourceId;
    protected final String departmentName;
    protected final double baseRate;

    protected boolean usageRecorded;
    protected double lastCalculatedCost;

    public EnterpriseResource(String resourceId,
                              String departmentName,
                              double baseRate) {
        this.resourceId = resourceId;
        this.departmentName = departmentName;
        this.baseRate = baseRate;
    }

    public final void recordUsage() {
        validateUsage();
        usageRecorded = true;
    }

    public final void calculateCost() {
        if (!usageRecorded) {
            throw new IllegalStateException("Usage not recorded");
        }
        lastCalculatedCost = computeCost();
    }

    public final void generateBill() {
        printBillHeader();
        printUsageDetails();
        printPricingRules();
        System.out.println("Final Amount: " + lastCalculatedCost);
    }

    protected abstract void validateUsage();
    protected abstract double computeCost();
    protected abstract void printUsageDetails();
    protected abstract void printPricingRules();

    private void printBillHeader() {
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Department: " + departmentName);
    }

    public String getResourceId() {
        return resourceId;
    }

    public double getLastCalculatedCost() {
        return lastCalculatedCost;
    }

    public abstract String auditSummary();
}
