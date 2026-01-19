package com.tss.test;

import com.tss.model.Student;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Student Details: ");
        System.out.print("Enter id: ");
        int id = scan.nextInt();

        System.out.print("Enter name: ");
        String name = scan.next();

        System.out.print("Enter course name: ");
        String course = scan.next();

        System.out.print("Enter paid fees: ");
        double feesPaid = scan.nextDouble();

        System.out.print("Enter total fees: ");
        double totalFees = scan.nextDouble();

        Student s = new Student(id, name, course, feesPaid, totalFees);

        boolean running = true;

        while (running) {
            System.out.println("\n1. Display Student Profile");
            System.out.println("2. Pay Fees");
            System.out.println("3. Pending Fees");
            System.out.println("4. Update Course");
            System.out.println("5. Exit");

            int opt;
            while (true) {
                System.out.print("Select Option (1-5): ");
                opt = scan.nextInt();

                if (opt >= 1 && opt <= 5) {
                    break;
                } else {
                    System.out.println("Invalid option..!");
                }
            }

            switch (opt) {
                case 1:
                    s.displayProfile();
                    break;

                case 2:
                    System.out.print("Enter amount to pay: ");
                    double amount = scan.nextDouble();
                    s.payFees(amount);
                    System.out.println("Fees paid successfully.");
                    break;

                case 3:
                    System.out.println("Pending fees: " + s.getPendingFees());
                    break;

                case 4:
                    System.out.print("Enter new course: ");
                    s.setCourse(scan.next());
                    System.out.println("Course updated successfully.");
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    running = false;
                    break;
            }
        }

        scan.close();
    }
}
