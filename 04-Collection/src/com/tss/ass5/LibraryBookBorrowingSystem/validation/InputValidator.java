package com.tss.ass5.LibraryBookBorrowingSystem.validation;

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

    public static String readNonEmptyString(Scanner scan, String message) {
        while (true) {
            System.out.print(message);
            String input = scan.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    public static String readValidIsbn(Scanner scan, String message) {
        while (true) {
            System.out.print(message + ": ");
            String isbn = scan.nextLine().trim();

            if (isbn.matches("[0-9-]{10,20}")) {
                return isbn;
            }

            System.out.println("Invalid ISBN. Use digits and hyphens only (10–20 characters).");
        }
    }

    public static String readValidName(Scanner scan, String message) {
        while (true) {
            System.out.print(message + ": ");
            String name = scan.nextLine().trim();

            if (name.matches("[a-zA-Z ]{3,30}")) {
                return name;
            }

            System.out.println("Invalid name. Use only letters (3–30 characters).");
        }
    }

    public static String readValidEmail(Scanner scan, String message) {
        while (true) {
            System.out.print(message + ": ");
            String email = scan.nextLine().trim();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            }
            System.out.println("Please enter a valid email address.");
        }
    }


    public static <T extends Enum<T>> T readEnum(
            Scanner scan,
            String title,
            Class<T> enumClass
    ) {
        T[] values = enumClass.getEnumConstants();

        while (true) {
            System.out.println("\n" + title);
            System.out.println("--------------------------------");

            for (int i = 0; i < values.length; i++) {
                System.out.printf("%2d. %s%n", i + 1, formatEnum(values[i].name()));
            }

            System.out.print("Enter choice (1-" + values.length + "): ");

            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine(); // clear buffer

                if (choice >= 1 && choice <= values.length) {
                    return values[choice - 1];
                }
            } else {
                scan.nextLine(); // clear invalid input
            }

            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static String formatEnum(String name) {
        String[] words = name.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return result.toString().trim();
    }

}
