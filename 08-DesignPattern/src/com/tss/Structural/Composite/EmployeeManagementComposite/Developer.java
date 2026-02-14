package com.tss.Structural.Composite.EmployeeManagementComposite;

public class Developer implements Employee {

    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails(int indentLevel) {
        printIndent(indentLevel);
        System.out.println("Developer: " + name + ", Salary: " + salary);
    }

    private void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("    ");
        }
    }
}
