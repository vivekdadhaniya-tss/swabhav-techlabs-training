package com.tss.ass1.test;

import com.tss.ass1.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Enter Student Details: ");

        while(true) {
            try {
                System.out.print("Enter id: ");
                int id = scan.nextInt();
                scan.nextLine();
                s.setId(id);
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID must be integer. Please enter again.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please enter again.");
            }
        }

        while(true) {
            try {
                System.out.print("Enter name: ");
                String name = scan.nextLine();
                s.setName(name);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please enter again.");
            }
        }

        while(true) {
            try {
                System.out.print("Enter course name: ");
                String course = scan.nextLine();
                s.setCourse(course);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please enter again.");
            }
        }

        while(true) {
            try {
                System.out.print("Enter paid fees: ");
                double feesPaid = scan.nextDouble();
                s.setFeesPaid(feesPaid);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please enter again.");
            } catch (InputMismatchException e) {
                System.out.println("Fees must be a number. Please enter again.");
                scan.nextLine();
            }
        }

        while(true) {
            try {
                System.out.print("Enter total fees: ");
                double totalFees = scan.nextDouble();
                s.setTotalFees(totalFees);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please enter again.");
            } catch (InputMismatchException e) {
                System.out.println("Fees must be a number. Please enter again.");
                scan.nextLine();
            }

        }

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
                scan.nextLine();

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
                    if (s.getPendingFees() == 0) {
                        System.out.println("All fees are already paid.");
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Enter amount to pay: ");
                            double amount = scan.nextDouble();
                            s.payFees(amount);
                            break;
                        }catch (InputMismatchException e) {
                            System.out.println("Fees must be a number. Please enter again.");
                            scan.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + " Please enter again.");
                        }
                    }
                    System.out.println("Fees paid successfully.");
                    break;

                case 3:
                    System.out.println("Pending fees: " + s.getPendingFees());
                    break;

                case 4:
                    while(true) {
                        try {
                            System.out.print("Enter new course name: ");
                            String course = scan.nextLine();
                            s.setCourse(course);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + " Please enter again.");
                        }
                    }
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
