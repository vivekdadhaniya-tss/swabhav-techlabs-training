package com.tss.evaluation1;

import com.tss.evaluation1.model.Employee;
import com.tss.service.EmployeeDirectory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeDirectory directory = new EmployeeDirectory();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    -------------------------
                    1. Add Employee
                    2. Top 3 Highest Salaries
                    3. Exit
                    -------------------------
                    """);

            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scan.nextDouble();

                    Employee employee = new Employee(name, salary);
                    directory.addEmployee(employee);
                }

                case 2 -> {
                    Employee[] topEmployees = directory.top3HighestPaid();
                    for (Employee e : topEmployees) {
                        System.out.println(e);
                    }
                }

                case 3 -> {
                    System.out.println("Thank you!");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }

        }
    }
}
