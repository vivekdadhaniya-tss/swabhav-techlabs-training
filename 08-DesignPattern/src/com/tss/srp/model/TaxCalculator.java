package com.tss.srp.model;

public class TaxCalculator {

    private final Invoice invoice;

    public TaxCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    public double calculateTax() {
        return invoice.getAmount() * invoice.getTaxPercentage();
    }

    public double calculateTotalAmount() {
        return invoice.getAmount() + calculateTax();
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
