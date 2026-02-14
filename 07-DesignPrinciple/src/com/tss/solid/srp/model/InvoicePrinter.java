package com.tss.solid.srp.model;

public class InvoicePrinter {

    private final TaxCalculator taxCalculator;

    public InvoicePrinter(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void printInvoice() {
        Invoice invoice = taxCalculator.getInvoice();

        double tax = taxCalculator.calculateTax();
        double total = taxCalculator.calculateTotalAmount();

        System.out.println("Invoice ID: " + invoice.getId());
        System.out.println("Amount: " + invoice.getAmount());
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + total);
    }
}
