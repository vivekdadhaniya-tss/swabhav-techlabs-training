package com.tss.ass3.v4.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    private InputUtils() {} // prevent object creation

    public static int readInt(Scanner scan, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int value = scan.nextInt();
                scan.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scan.nextLine();
            }
        }
    }

    public static int readPositiveInt(Scanner scan, String msg) {
        while (true) {
            int value = readInt(scan, msg);
            if (value > 0) return value;
            System.out.println("Value must be greater than 0.");
        }
    }

    public static double readPositiveDouble(Scanner scan, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double value = scan.nextDouble();
                scan.nextLine();
                if (value > 0) return value;
                System.out.println("Value must be greater than 0.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid amount.");
                scan.nextLine();
            }
        }
    }

    public static String readName(Scanner scan, String msg) {
        while (true) {
            System.out.print(msg);
            String input = scan.nextLine().trim();
            if (!input.isBlank() && input.matches("[a-zA-Z ]+"))
                return input;
            System.out.println("Only letters allowed and cannot be empty.");
        }
    }

    public static int readIntInRange(Scanner scan, String msg, int min, int max) {
        while (true) {
            int value = readInt(scan, msg);
            if (value >= min && value <= max)
                return value;
            System.out.println("Enter value between " + min + " and " + max);
        }
    }
}
