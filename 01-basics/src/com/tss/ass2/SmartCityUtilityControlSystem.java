package com.tss.ass2;

import java.util.Scanner;

public class SmartCityUtilityControlSystem {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("=== SMART CITY UTILITY CONTROL SYSTEM ===");
            System.out.println("1. Electricity Service");
            System.out.println("2. Water Service");
            System.out.println("3. Internet Service");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    electricityService();
                    break;
                case 2:
                    waterService();
                    break;
                case 3:
                    internetService();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void electricityService() {

        while (true) {
            System.out.println("\n--- Electricity Service ---");
            System.out.println("1. Domestic Connection");
            System.out.println("2. Commercial Connection");
            System.out.println("3. Industrial Connection");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int choice = scan.nextInt();

            if (choice == 4)
                return;

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            System.out.print("Enter units consumed: ");
            int units = scan.nextInt();

            if(units <= 0) {
                System.out.println("Enter valid units (must be positive)");
                continue;
            }

            double energyCharge = 0;
            double fixedCharge = 0;
            double extra = 0;
            double total;

            switch (choice) {
                case 1:
                    if (units <= 100)
                        energyCharge = units * 2;
                    else if (units <= 300)
                        energyCharge = units * 3;
                    else
                        energyCharge = units * 5;

                    fixedCharge = 50;

                    total = energyCharge + fixedCharge;
                    if (total > 2000)
                        extra = total * 0.10;

                    System.out.println("Connection Type: Domestic");
                    break;

                case 2:
                    if (units <= 200)
                        energyCharge = units * 5;
                    else if (units <= 500)
                        energyCharge = units * 7;
                    else
                        energyCharge = units * 10;

                    fixedCharge = 150;
                    System.out.println("Connection Type: Commercial");
                    break;

                case 3:
                    energyCharge = units * 12;
                    fixedCharge = 500;

                    if (units > 1000)
                        extra = -(energyCharge + fixedCharge) * 0.15;

                    System.out.println("Connection Type: Industrial");
                    break;

                default:
                    System.out.println("Invalid option");
                    continue;
            }

            total = energyCharge + fixedCharge + extra;

            System.out.println("Units: " + units);
            System.out.println("Energy Charge: Rs. " + energyCharge);
            System.out.println("Fixed Charge: Rs. " + fixedCharge);
            System.out.println("Extra/Rebate: Rs. " + extra);
            System.out.println("Total Bill: Rs. " + total);
        }
    }

    public static void waterService() {

        while (true) {
            System.out.println("\n--- Water Service ---");
            System.out.println("1. Residential");
            System.out.println("2. Society");
            System.out.println("3. Factory");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int choice = scan.nextInt();

            if (choice == 4) {
                return;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            double total = 0;

            switch (choice) {
                case 1:
                    System.out.print("Enter number of persons: ");
                    total = scan.nextInt() * 30;
                    if (total <= 0) continue;
                    break;
                case 2:
                    System.out.print("Enter number of taps: ");
                    total = scan.nextInt() * 25;
                    if (total <= 0) continue;
                    break;
                case 3:
                    System.out.print("Enter number of machines: ");
                    total = scan.nextInt() * 100;
                    if (total <= 0) continue;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option!");
                    continue;
            }

            if (total > 3000)
                total += total * 0.08;

            System.out.println("Total Water Bill: Rs. " + total);
        }
    }

    public static void internetService() {

        while (true) {
            System.out.println("\n--- Internet Service ---");
            System.out.println("1. Student Plan");
            System.out.println("2. Home Plan");
            System.out.println("3. Business Plan");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int plan = scan.nextInt();

            if (plan == 4)
                return;

            if (plan < 1 || plan > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            System.out.print("Enter duration (1 / 3 / 6 months): ");
            int duration = scan.nextInt();

            double amount = 0;

            switch (plan) {
                case 1:
                    if (duration == 1) amount = 299;
                    else if (duration == 3) amount = 799;
                    else if (duration == 6) amount = 1499;
                    else {
                        System.out.println("Invalid duration");
                        continue;
                    }
                    break;

                case 2:
                    if (duration == 1) amount = 499;
                    else if (duration == 3) amount = 1399;
                    else if (duration == 6) amount = 2699;
                    else {
                        System.out.println("Invalid duration");
                        continue;
                    }
                    break;

                case 3:
                    if (duration == 1) amount = 999;
                    else if (duration == 3) amount = 2799;
                    else if (duration == 6) amount = 5499;
                    else {
                        System.out.println("Invalid duration");
                        continue;
                    }
                    break;

                default:
                    System.out.println("Invalid plan");
                    continue;
            }

            if (duration == 6)
                amount -= amount * 0.05;

            System.out.println("Total Internet Bill: Rs. " + amount);
        }
    }
}