package com.tss.ass1;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {

        System.out.print("Enter number : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int originalNum = num;
        int temp = num;
        int len = 0;

        while(temp!=0) {
            len++;
            temp/=10;
        }
        int result = 0;
        while(num !=0) {
            int digit = num%10;
            num /= 10;
            result += (int) Math.pow(digit,len);
        }

        if (result == originalNum) {
            System.out.println("Number is Armstrong");
        } else {
            System.out.println("Number is not Armstrong");
        }

    }
}
