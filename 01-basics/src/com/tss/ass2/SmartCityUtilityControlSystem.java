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

    private static void electricityService() {
        while (true) {
            System.out.println("\n--- Electricity Service ---");
            System.out.println("1. Domestic Connection");
            System.out.println("2. Commercial Connection");
            System.out.println("3. Industrial Connection");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int connection = scan.nextInt();
            if (connection == 4) return;
            if (connection < 1 || connection > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            int units;
            while (true) {
                System.out.print("Enter number of consumed units: ");
                units = scan.nextInt();
                if (units > 0) break;
                System.out.println("Units must be positive!");
            }

            double[] charges = calculateElectricityBill(connection, units);
            printElectricityBill(connection, units, charges);
        }
    }


    private static double[] calculateElectricityBill(int connection, int units) {
        double energyCharge = 0;
        double fixedCharge = 0;
        double extra = 0;

        switch (connection) {
            case 1 -> { // Domestic
                if (units <= 100) energyCharge = units * 2;
                else if (units <= 300) energyCharge = units * 3;
                else energyCharge = units * 5;

                fixedCharge = 50;

                if (energyCharge + fixedCharge > 2000) extra = (energyCharge + fixedCharge) * 0.10;
            }
            case 2 -> { // Commercial
                if (units <= 200) energyCharge = units * 5;
                else if (units <= 500) energyCharge = units * 7;
                else energyCharge = units * 10;

                fixedCharge = 150;
            }
            case 3 -> { // Industrial
                energyCharge = units * 12;
                fixedCharge = 500;

                if (units > 1000) extra = -(energyCharge + fixedCharge) * 0.15;
            }
        }

        double total = energyCharge + fixedCharge + extra;
        return new double[]{energyCharge, fixedCharge, extra, total};
    }

    private static void printElectricityBill(int connection, int units, double[] charges) {
        String connectionType = switch (connection) {
            case 1 -> "Domestic";
            case 2 -> "Commercial";
            case 3 -> "Industrial";
            default -> "Unknown";
        };

        System.out.println("Connection Type: " + connectionType);
        System.out.println("Units: " + units);
        System.out.println("Energy Charge: Rs. " + charges[0]);
        System.out.println("Fixed Charge: Rs. " + charges[1]);
        System.out.println("Extra/Rebate: Rs. " + charges[2]);
        System.out.println("Total Bill: Rs. " + charges[3]);
    }


    private static void waterService() {

        while (true) {

            System.out.println("\n--- Water Service ---");
            System.out.println("1. Residential");
            System.out.println("2. Society");
            System.out.println("3. Factory");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int choice = scan.nextInt();

            if (choice == 4)  return;
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            int count;
            while (true) {
                System.out.print("Enter number of persons / taps / machines: ");
                count = scan.nextInt();
                if (count > 0) break;
                System.out.println("Value must be positive!");
            }

            double total = switch(choice) {
                case 1 -> count * 30;
                case 2 -> count * 25;
                case 3 -> count * 100;
                default -> 0;
            };

            if (total > 3000)
                total += total * 0.08;

            System.out.println("Total Water Bill: Rs. " + total);
        }
    }

    private static void internetService() {

        while (true) {
            System.out.println("\n--- Internet Service ---");
            System.out.println("1. Student Plan");
            System.out.println("2. Home Plan");
            System.out.println("3. Business Plan");
            System.out.println("4. Back");
            System.out.print("Select option: ");

            int plan = scan.nextInt();

            if (plan == 4)  return;
            if (plan < 1 || plan > 3) {
                System.out.println("Invalid option! Please select 1–4.");
                continue;
            }

            int duration;
            while(true) {
                System.out.print("Enter duration (1 / 3 / 6 months): ");
                duration = scan.nextInt();
                if (duration == 1 || duration == 3 || duration == 6) break;
                System.out.println("Invalid duration. Enter 1, 3, or 6 only.");
            }

            double bill = calculateInternetBill(plan, duration);
            System.out.println("Total Internet Bill: Rs. " + bill);
        }
    }

    private static double calculateInternetBill(int plan, int duration) {

        double bill = switch(plan) {
            case 1 -> (duration == 1) ? 299 : (duration == 3) ? 799 : 1499;
            case 2 -> (duration == 1) ? 499 : (duration == 3) ? 1399 : 2699;
            case 3 -> (duration == 1) ? 999 : (duration == 3) ? 2799 : 5499;
            default -> 0;
        };

        if(duration == 6) {
            bill -= bill * 0.05;
        }
        return bill;
    }
}