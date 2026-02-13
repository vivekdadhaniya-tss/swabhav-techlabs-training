package com.tss.Creational.Factory.test;

import com.tss.Creational.Factory.model.Car;
import com.tss.Creational.Factory.model.CarFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Car Factory Menu =====");
            System.out.println("1. BMW");
            System.out.println("2. BYD");
            System.out.println("3. MARUTI");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            String type = null;

            switch (choice) {
                case 1:
                    type = "BMW";
                    break;
                case 2:
                    type = "BYD";
                    break;
                case 3:
                    type = "MARUTI";
                    break;
                case 4:
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            Car car = CarFactory.getCar(type);

            if (car != null) {
                car.drive();
            }

        } while (choice != 4);

        scanner.close();
    }
}
