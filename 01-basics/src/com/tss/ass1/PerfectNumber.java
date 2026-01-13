package com.tss.ass1;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {

        System.out.println("Enter number : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(num <= 1) {
            System.out.println("Not Perfect");
        }

        int sum = 0;
        for(int i =1; i < num; i++) {
            if(num % i ==0) {
                sum += i;
            }
        }

        if( sum == num) {
            System.out.println("Perfect");
        } else {
            System.out.println("Not Perfect");
        }
    }
}
