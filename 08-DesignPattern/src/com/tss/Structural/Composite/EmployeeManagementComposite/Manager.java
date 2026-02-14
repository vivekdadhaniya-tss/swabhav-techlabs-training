package com.tss.Structural.Composite.EmployeeManagementComposite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;
    private double salary;
    private List<Employee> subordinates = new ArrayList<>();

    public  Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public void showDetails(int indentLevel) {
        printIndent(indentLevel);
        System.out.println("Manager: " + name + ", Salary: " + salary);

        for (Employee employee : subordinates) {
            employee.showDetails(indentLevel + 1);
        }
    }

    private void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("    ");
        }
    }
}
