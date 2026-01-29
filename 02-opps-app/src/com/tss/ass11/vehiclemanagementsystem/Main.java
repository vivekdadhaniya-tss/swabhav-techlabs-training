package com.tss.ass11.vehiclemanagementsystem;

import com.tss.ass11.vehiclemanagementsystem.model.*;
import com.tss.ass11.vehiclemanagementsystem.model.*;

import java.util.Scanner;

public class Main {

    static Vehicle[] vehicles = new Vehicle[10];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Vehicle Management System ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Start Vehicle");
            System.out.println("3. Stop Vehicle");
            System.out.println("4. Charge Battery");
            System.out.println("5. Play Horn / Music");
            System.out.println("6. Vehicle Inspection");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addVehicle(sc);
                case 2 -> operateVehicle(sc, "start");
                case 3 -> operateVehicle(sc, "stop");
                case 4 -> chargeBattery(sc);
                case 5 -> playFeatures(sc);
                case 6 -> Vehicle.vehicleInspection();
            }

        } while (choice != 0);
    }

    static void addVehicle(Scanner sc) {

        System.out.println("Select Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");

        int type = sc.nextInt();

        System.out.println("Select Power Type:");
        System.out.println("1. Petrol");
        System.out.println("2. Electric");

        int power = sc.nextInt();

        Vehicle v = null;

        if (type == 1 && power == 1)
            v = new Car();
        else if (type == 1 && power == 2)
            v = new ElectricCar();
        else if (type == 2 && power == 1)
            v = new Bike();
        else if (type == 2 && power == 2)
            v = new ElectricBike();
        else if (type == 3 && power == 1)
            v = new Truck();
        else if (type == 3 && power == 2)
            v = new ElectricTruck();

        if (v != null) {
            vehicles[count++] = v;
            System.out.println("Vehicle added with ID: " + v.getId());
        } else {
            System.out.println("Invalid selection");
        }
    }

    static void operateVehicle(Scanner sc, String action) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (vehicles[i].getId() == id) {
                if (action.equals("start"))
                    vehicles[i].start();
                else
                    vehicles[i].stop();
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    static void chargeBattery(Scanner sc) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (vehicles[i].getId() == id &&
                    vehicles[i] instanceof ElectricVehicle ev) {
                ev.chargeBattery();
                return;
            }
        }
        System.out.println("This vehicle is not electric");
    }

    static void playFeatures(Scanner sc) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (vehicles[i].getId() == id) {
                vehicles[i].horn();
                vehicles[i].playMusic();
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
}
