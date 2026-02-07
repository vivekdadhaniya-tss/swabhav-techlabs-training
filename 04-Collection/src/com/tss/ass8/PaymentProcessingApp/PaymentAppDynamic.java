package com.tss.ass8.PaymentProcessingApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentAppDynamic {

    private static final Map<String, Payment> paymentMethod = new HashMap<>();

    static {
        paymentMethod.put("CREDIT_CARD", amount -> amount <= 100000);
        paymentMethod.put("UPI", amount -> amount <= 50000);
        paymentMethod.put("NET_BANKING", amount -> true);
    }

    public static void processPayment(Payment payment, double amount) {
        boolean result = payment.pay(amount);
        System.out.println(result ? "Payment Successful\n" : "Payment Failed\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter payment type (CREDIT_CARD, UPI, NET_BANKING): ");
        String type = scan.nextLine().toUpperCase().trim();

        System.out.print("Enter the amount: ");
        double amount = scan.nextDouble();

        Payment payment = paymentMethod.get(type);

        if(payment == null) {
            System.out.println("Invalid payment method");
            return;
        }

        System.out.println("Processing " + type + " payment of ₹" + amount);
        processPayment(payment, amount);
    }
}
