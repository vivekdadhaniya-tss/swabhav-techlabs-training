package com.tss.ass1;

import java.util.Scanner;

public class WaterBillApp {
    public static void main(String[] args) {

        System.out.print("Enter the number of units: ");
        Scanner scan = new Scanner(System.in);
        int unit_consume = scan.nextInt();

        int meter_charge = 75;

        if(unit_consume < 0) {
            System.out.println("Consume units must be positive");
            return;
        }

        int unit_charge = 0;

        if(unit_consume <= 100) {
            unit_charge = unit_consume * 5;
        } else {
            if(unit_consume <= 250) {
                unit_charge = unit_consume * 10;
            } else {
                unit_charge = unit_consume * 20;
            }
        }
        int total_water_bill = unit_charge + meter_charge;
        System.out.println("Total water bill : " + total_water_bill);
    }
}
