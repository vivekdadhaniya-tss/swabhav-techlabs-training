package com.tss.Creational.Abstract.test;

import com.tss.Creational.Abstract.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Abstract Car Factory Menu =====");
            System.out.println("1. BMW");
            System.out.println("2. BYD");
            System.out.println("3. MARUTI");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            CarFactory factory = null;

            switch (choice) {
                case 1:
                    factory = new BMWFactory();
                    break;
                case 2:
                    factory = new BYDFactory();
                    break;
                case 3:
                    factory = new MarutiFactory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            Car car = factory.createCar();
            car.drive();

        } while (choice != 4);

        scanner.close();
    }
}
