package com.tss.Structural.Decorator.HatShop;

import java.util.Scanner;

public class HatShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IHat hat = null;

        System.out.println("===== Welcome to Hat Shop =====");
        System.out.println("1. Standard Hat (500)");
        System.out.println("2. Premium Hat (1000)");
        System.out.print("Choose Base Hat: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                hat = new StandardHat();
                break;
            case 2:
                hat = new PremiumHat();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        boolean isGoldenAdded = false;
        boolean isRibbonAdded = false;

        int option;
        do {
            System.out.println("\nAdd Decorations:");
            System.out.println("1. Add Golden (+200)");
            System.out.println("2. Add Ribbon (+100)");
            System.out.println("3. Finish");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    if (!isGoldenAdded) {
                        hat = new GoldenHat(hat);
                        isGoldenAdded = true;
                        System.out.println("Golden decoration added!");
                    } else {
                        System.out.println("Golden already added!");
                    }
                    break;

                case 2:
                    if (!isRibbonAdded) {
                        hat = new RibbonedHat(hat);
                        isRibbonAdded = true;
                        System.out.println("Ribbon decoration added!");
                    } else {
                        System.out.println("Ribbon already added!");
                    }
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 3);

        System.out.println("\n===== Final Hat Details =====");
        System.out.println("Name: " + hat.getName());
        System.out.println("Description: " + hat.getDescription());
        System.out.println("Total Price: " + hat.getPrice());

        sc.close();
    }
}