package com.tss.ass1;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 3 numbers :");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int max = Math.max(a, Math.max(b,c));

        System.out.println("Max Number : " + max);
    }
}
