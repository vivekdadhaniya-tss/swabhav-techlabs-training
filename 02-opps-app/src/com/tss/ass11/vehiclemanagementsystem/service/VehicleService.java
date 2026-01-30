package com.tss.ass11.vehiclemanagementsystem.service;

import com.tss.ass11.vehiclemanagementsystem.model.*;

import java.util.Scanner;

public class VehicleService {

    private static Vehicle[] vehicles;
    private static int count = 0;

    public VehicleService() {
        vehicles = new Vehicle[10];
    }

    public boolean hasVehicles() {
        if (count == 0) {
            System.out.println("No vehicles found. Please add a vehicle first.");
            return false;
        }
        return true;
    }

    public Vehicle findVehicleById(int id) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getId() == id) {
                return vehicles[i];
            }
        }
        return null;
    }


    public void addVehicle(Scanner sc) {

        if (count >= vehicles.length) {
            System.out.println("Vehicle limit reached. Cannot add more vehicles.");
            return;
        }

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

    public void operateVehicle(Scanner sc, String action) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        Vehicle v = findVehicleById(id);

        if (v == null) {
            System.out.println("Vehicle not found");
            return;
        }

        if (action.equals("start"))
            v.start();
        else
            v.stop();
    }

    public void chargeBattery(Scanner sc) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        Vehicle v = findVehicleById(id);

        if (v == null) {
            System.out.println("Vehicle not found");
            return;
        }

        if (v instanceof ElectricVehicle ev) {
            ev.chargeBattery();
        } else {
            System.out.println("This vehicle does not support battery charging");
        }
    }

    public void playFeatures(Scanner sc) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        Vehicle v = findVehicleById(id);

        if (v == null) {
            System.out.println("Vehicle not found");
            return;
        }

        v.horn();
        v.playMusic();
    }

    public void displayAllVehicles() {

        if (count == 0) {
            System.out.println("No vehicles available to display.");
            return;
        }

        System.out.println("\n--- Vehicle List ---");

        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];

            System.out.println(
                    "ID: " + v.getId() +
                            "  " + v.getClass().getSimpleName()
            );
        }
    }

}
