package com.tss.ass4;

import java.util.Scanner;

public class ProductArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();

        int[] nums = new int[size];

        int comProd = 1;
        int zeroCount = 0;

        System.out.println("Enter sorted array elements: ");
        for(int i = 0; i < size; i++) {
            nums[i] = scan.nextInt();
            if(nums[i] != 0) comProd *= nums[i];
            else zeroCount++;
        }

        int []prods = new int[size];

        if(zeroCount > 1) {
            System.out.println("Product Array: ");
            for(int prod : prods){
                System.out.println(prod + " ");
            }
            return;
        }

        for(int i = 0; i < size; i++) {
            if(nums[i] != 0) prods[i] = comProd/nums[i];
            else prods[i] = comProd;
        }

        System.out.println("Product Array: ");
        for(int prod : prods){
            System.out.print(prod + " ");
        }
    }
}
