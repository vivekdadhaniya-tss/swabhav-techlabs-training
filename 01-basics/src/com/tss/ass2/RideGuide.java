package com.tss.ass2;

import java.util.Scanner;

public class RideGuide {
    public static void main(String[] args) {
        System.out.println("Enter the height : ");
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();

        if(height < 120) {
            System.out.println("Can't ride...");
        } else {
            System.out.println(" You can ride...");
            System.out.println("Enter the age : ");
            int age = scan.nextInt();
            int rideCharge = 0;
            if(age < 12) {
                rideCharge = 5;
            } else if (age > 12 && age < 18) {
                rideCharge = 7;
            } else if (age >= 18 && age <= 44) {
                rideCharge = 12;
            } else {
                rideCharge = 0;
            }

            System.out.println("Want photos: ");
            String res = scan.next().toLowerCase();
            int photoCharge = 0;

            if(res.equals("yes")) {
                photoCharge = 3;
            }

            int totalCharge = rideCharge + photoCharge;
            System.out.println("Total charge :" + totalCharge);
        }
    }
}
