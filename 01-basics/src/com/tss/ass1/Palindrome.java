package com.tss.ass1;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter the number : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        String Str = String.valueOf(num);
        StringBuilder numStr = new StringBuilder(Str);
        StringBuilder revStr = numStr.reverse();

        if(numStr == revStr) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
