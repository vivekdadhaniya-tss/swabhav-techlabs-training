package com.tss.ass1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Enter the number : ");
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        boolean prime = checkPrime(num);

        if(prime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }

    private static boolean checkPrime(int num) {
        if(num <= 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for(int i = 3; i <Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
