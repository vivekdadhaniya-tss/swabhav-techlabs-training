package com.tss.ass8.util;

import java.util.Scanner;

public final class InputValidator {
    private InputValidator() {}

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Only numbers allowed.");
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Only numeric value allowed.");
            }
        }
    }

    public static String readName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (isValidName(input)) return input;
            System.out.println("Invalid name! Use alphabets only (min 2 characters).");
        }
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]{2,}");
    }

    public static boolean isValidDuration(int years) {
        return years >= 0 && years <= 50;
    }

    public static boolean isValidAmount(double amount) {
        return !(amount > 0);
    }
}
