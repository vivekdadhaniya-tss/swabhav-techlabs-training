package com.tss.ass4;

import java.util.Scanner;

public class SquareArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();

        int []nums = new int[size];

        System.out.println("Enter sorted array elements: ");
        for(int i = 0; i < size; i++) {
            nums[i] = scan.nextInt();
        }

        int []ans = squareArrSort(nums,size);

        System.out.println("Square sorted array: ");
        for(int num : ans) {
            System.out.print(num + " ");
        }
    }

    private static int[] squareArrSort(int []nums,int size) {
        int[] ans = new int[size];
        int left = 0;
        int right = size - 1;
        int index = size -1;

        while(left <= right) {

            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];

            if(leftSquare > rightSquare) {
                ans[index] = leftSquare;
                left++;
            } else {
                ans[index] = rightSquare;
                right--;
            }
            index--;
        }

        return ans;
    }
}
