package com.tss.ass4;

import java.util.Scanner;

public class FindPeakElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();

        int []nums = new int[size];

        System.out.println("Enter " + "size " + "array elements: ");
        for(int i = 0; i < size; i++) {
            nums[i] = scan.nextInt();
        }

        int peakElement = findPeakElement(nums,size);
        if (peakElement == Integer.MIN_VALUE) {
            System.out.println("No peak element found or array is empty/invalid.");
        } else {
            System.out.println("Peak element: " + peakElement);
        }

    }

    private static int findPeakElement(int[] nums, int size) {

        if(size ==0) return Integer.MIN_VALUE;
        if(size == 1)   return nums[0];

        if(nums[0] > nums[1])   return nums[0];

        for(int i = 1; i < size - 1; i++) {
            if(nums[i-1] <= nums[i] && nums[i] >= nums[i+1]) {
                return nums[i];
            }
        }

        if(nums[size-1] > nums[size - 2])   return nums[size -1];

        return Integer.MIN_VALUE;
    }
}
