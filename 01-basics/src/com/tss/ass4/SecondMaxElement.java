package com.tss.ass4;

import java.util.Scanner;

public class SecondMaxElement {
    public static void main(String[] args) {
        System.out.println("Enter 5 array elements:");
        Scanner scan = new Scanner(System.in);
        int []arr = new int[5];
        int max = arr[0];
        int secondMax = arr[0];

        for(int i =0;i<5;i++) {
            arr[i]= scan.nextInt();

            if(max < arr[i]) {
                secondMax = max;
                max = arr[i];
            } else if(secondMax < arr[i] && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println("Second Max :" + secondMax);
    }
}
