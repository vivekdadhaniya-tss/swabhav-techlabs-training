package com.tss.srp.test;

import com.tss.srp.model.Invoice;
import com.tss.srp.model.InvoicePrinter;
import com.tss.srp.model.TaxCalculator;

public class Main {
    public static void main(String[] args) {

        Invoice invoice = new Invoice("Laptop", 50000, 0.18);
        TaxCalculator taxCalculator = new TaxCalculator(invoice);
        InvoicePrinter printer = new InvoicePrinter(taxCalculator);

        printer.printInvoice();

    }
}
