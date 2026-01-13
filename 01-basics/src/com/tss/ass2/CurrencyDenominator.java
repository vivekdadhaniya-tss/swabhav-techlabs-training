package com.tss.ass2;

import java.util.Scanner;

public class CurrencyDenominator {
    public static void main(String[] args) {

        System.out.println("Enter the amount:");
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();

        if(amount > 50000) {
            System.out.println("Amount must be below 50000");
            return;
        }

        if(amount <= 0) {
            System.out.println("Amount must be positive");
        }

        if(amount % 100 != 0) {
            System.out.println("Amount must be multiple of 100");
            return;
        }

        int[] currencyAva = {2000,500,200,100};
        int[] currCount = new int[currencyAva.length];

        for(int i = 0; i < currencyAva.length; i++) {
            if(amount >= currencyAva[i]) {
                currCount[i] = amount / currencyAva[i];
                amount = amount % currencyAva[i];
            }
        }


        for(int i = 0; i < currCount.length; i++) {
            System.out.println(currencyAva[i] + " : " + currCount[i]);
        }
    }
}
