package com.tss.ass11.vehiclemanagementsystem;

import com.tss.ass11.vehiclemanagementsystem.service.VehicleService;
import com.tss.ass11.vehiclemanagementsystem.model.Vehicle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleService service = new VehicleService();
        int choice;

        do {
            System.out.println("\n--- Vehicle Management System ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Start Vehicle");
            System.out.println("3. Stop Vehicle");
            System.out.println("4. Charge Battery");
            System.out.println("5. Play Horn / Music");
            System.out.println("6. Vehicle Inspection");
            System.out.println("7. Display All Vehicles");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1 -> service.addVehicle(sc);
                case 2 -> {
                    if (service.hasVehicles()) {
                        service.operateVehicle(sc, "start");
                    }
                }
                case 3 -> {
                    if (service.hasVehicles()) {
                        service.operateVehicle(sc, "stop");
                    }
                }
                case 4 -> {
                    if (service.hasVehicles()) {
                        service.chargeBattery(sc);
                    }
                }
                case 5 -> {
                    if (service.hasVehicles()) {
                        service.playFeatures(sc);
                    }
                }
                case 6 -> Vehicle.vehicleInspection();
                case 7 -> service.displayAllVehicles();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}