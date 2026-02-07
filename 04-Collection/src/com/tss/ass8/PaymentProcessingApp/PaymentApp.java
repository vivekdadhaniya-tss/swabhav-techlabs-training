package com.tss.ass8.PaymentProcessingApp;

public class PaymentApp {

    public static void processPayment(Payment payment, double amount) {
        boolean result = payment.pay(amount);
        if (result) {
            System.out.println("Payment Successful\n");
        } else {
            System.out.println("Payment Failed\n");
        }
    }

    public static void main(String[] args) {

        Payment creditCard = amount -> amount <= 100000;
        System.out.println("Processing Credit Card payment of ₹120000");
        processPayment(creditCard, 120000);

        Payment upi = amount -> amount <= 50000;
        System.out.println("Processing UPI payment of ₹2500");
        processPayment(upi, 2500);


        Payment netBanking = amount -> true;
        System.out.println("Processing Net Banking payment of ₹75000");
        processPayment(netBanking, 75000);
    }
}
