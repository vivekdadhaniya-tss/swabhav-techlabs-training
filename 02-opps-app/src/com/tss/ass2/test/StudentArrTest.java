package com.tss.ass2.test;

import com.tss.ass2.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentArrTest {

    static Scanner scan = new Scanner(System.in);
    static Student[] students;
    static int maxStudents;
    static int currentStudents = 0;

    public static void main(String[] args) {

        // ----- Max Students -----
        while (true) {
            try {
                System.out.print("Enter number of students (max 10): ");
                maxStudents = scan.nextInt();
                scan.nextLine();

                if (maxStudents <= 0 || maxStudents > 10) {
                    throw new IllegalArgumentException("Enter value between 1 and 10");
                }

                students = new Student[maxStudents];
                break;

            } catch (InputMismatchException e) {
                System.out.println("Enter integer value only.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. Show Pending Fees");
            System.out.println("4. Display Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            int choice;
            try {
                System.out.print("Choose option: ");
                choice = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option.");
                scan.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> createStudent();
                case 2 -> payFees();
                case 3 -> showPendingFees();
                case 4 -> displayStudent();
                case 5 -> displayAllStudents();
                case 6 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
        scan.close();
    }

    private static Student findStudentById(int id) {
        for (int i = 0; i < currentStudents; i++) {
            if (students[i].getId() == id)
                return students[i];
        }
        return null;
    }

    private static int inputId() {
        while (true) {
            try {
                System.out.print("Enter Student ID: ");
                int id = scan.nextInt();
                scan.nextLine();
                return id;
            } catch (InputMismatchException e) {
                System.out.println("ID must be integer.");
                scan.nextLine();
            }
        }
    }

    private static void createStudent() {

        if (currentStudents >= maxStudents) {
            System.out.println("Maximum students reached.");
            return;
        }

        Student student = new Student();

        while (true) {
            try {
                System.out.print("Enter ID: ");
                int id = scan.nextInt();
                scan.nextLine();

                if (findStudentById(id) != null) {
                    throw new IllegalArgumentException("ID already exists");
                }

                student.setId(id);
                break;

            } catch (InputMismatchException e) {
                System.out.println("ID must be integer.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Name: ");
                student.setName(scan.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Course: ");
                student.setCourse(scan.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Fees Paid: ");
                double paid = scan.nextDouble();
                scan.nextLine();
                student.setFeesPaid(paid);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid amount.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Total Fees: ");
                double total = scan.nextDouble();
                scan.nextLine();
                student.setTotalFees(total);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid amount.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        students[currentStudents++] = student;
        System.out.println("Student added successfully.");
    }

    private static void payFees() {
        int id = inputId();
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            try {
                System.out.print("Enter amount: ");
                double amount = scan.nextDouble();
                scan.nextLine();
                student.payFees(amount);
                System.out.println("Payment successful.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid amount.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showPendingFees() {
        int id = inputId();
        Student student = findStudentById(id);

        if (student != null)
            System.out.println("Pending Fees: " + student.getPendingFees());
        else
            System.out.println("Student not found.");
    }

    private static void displayStudent() {
        int id = inputId();
        Student student = findStudentById(id);

        if (student != null)
            student.displayProfile();
        else
            System.out.println("Student not found.");
    }

    private static void displayAllStudents() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < currentStudents; i++) {
            students[i].displayProfile();
        }
    }
}