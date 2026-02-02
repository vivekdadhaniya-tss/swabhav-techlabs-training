package com.tss.evaluation1.service;

import com.tss.evaluation1.model.Employee;

import java.util.Arrays;

public class EmployeeDirectory {

    private static final int MAX_EMPLOYEES = 10;

    private final Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int count = 0;

    public void addEmployee(Employee employee) {
        if (count >= MAX_EMPLOYEES) {
            System.out.println("Employee limit reached.");
            return;
        }

        employees[count++] = employee;
        System.out.println("Employee " + employee.getId() + " added successfully.");
    }

    public Employee[] top3HighestPaid() {

        if (count == 0) {
            System.out.println("No employees available.");
            return new Employee[0];
        }

        Employee[] copy = Arrays.copyOf(employees, count);

        Arrays.sort(copy, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

        int resultSize = Math.min(3, copy.length);
        return Arrays.copyOf(copy, resultSize);
    }
}
