package com.tss;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = scan.next().toLowerCase();

        StringBuilder str = new StringBuilder(input);
        StringBuilder revStr = new StringBuilder(input).reverse();

        if(str.toString().equals(revStr.toString()))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");


        System.out.println("Enter String: ");
        String input2 = scan.next().toLowerCase();

        int start = 0;
        int end = input2.length();

        boolean status = true;
        while(start <= end) {
            if(input2.charAt(start) != input2.charAt(end -1)) {
                status = false;
                return;
            }
            start++;
            end--;
        }
        if (status) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

    }
}
