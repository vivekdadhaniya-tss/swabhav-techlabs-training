package com.tss.ass7.validation;

import java.util.Scanner;

public final class InputValidator {

    private InputValidator() {}

    public static int readInt(Scanner scan, String message) {
        System.out.print(message);
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid number");
            scan.next();
        }
        return scan.nextInt();
    }

    public static double readPositiveDouble(Scanner scan, String message) {
        System.out.print(message);
        while (!scan.hasNextDouble()) {
            System.out.println("Please enter a valid amount");
            scan.next();
        }
        double value = scan.nextDouble();
        if (value <= 0) {
            System.out.println("Amount must be greater than zero");
            return -1;
        }
        return value;
    }

    public static String readValidName(Scanner scan, String message) {
        System.out.print(message);
        scan.nextLine(); // clear buffer
        String name = scan.nextLine();
        if (!name.matches("[a-zA-Z ]{3,30}")) {
            System.out.println("Invalid name");
            return null;
        }
        return name;
    }
}
