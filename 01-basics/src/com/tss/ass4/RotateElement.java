package com.tss.ass4;

import java.util.Scanner;

public class RotateElement {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter " + size  + "array elements: ");
        for(int i = 0; i < size; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.print("Give the value for rotate element by right side: ");
        int rotateValue = scan.nextInt();
        rotateValue = rotateValue % size;

        rotateArr(nums, rotateValue,size);

        System.out.println("Array after rotation: ");
        for(int num : nums) {
            System.out.println(num);
        }
    }

    private static void rotateArr(int[] nums, int rotateValuue, int size) {
        if(size == 0 || rotateValuue == 0)   return;
        reverse(nums,0,size-1);
        reverse(nums,0,rotateValuue-1);
        reverse(nums,rotateValuue,rotateValuue-1);
    }

    private static void reverse(int []nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

//    private static int[] rotateArr(int[] nums, int k, int size) {
//        int[] result = new int[size];
//
//        int index = 0;
//
//        // copy last k elements
//        for (int i = size - k; i < size; i++) {
//            result[index++] = nums[i];
//        }
//
//        // copy remaining elements
//        for (int i = 0; i < size - k; i++) {
//            result[index++] = nums[i];
//        }
//
//        return result;
//    }
}
