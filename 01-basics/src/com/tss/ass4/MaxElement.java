package com.tss.ass4;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        System.out.println("Enter 5 array elements:");
        Scanner scan = new Scanner(System.in);
        int []arr = new int[5];
        int max = 0;
        for(int i =0;i<5;i++) {
            arr[i]= scan.nextInt();
            if(max < arr[i]) max = arr[i];
        }
        System.out.println("Max :" + max);
    }
}
