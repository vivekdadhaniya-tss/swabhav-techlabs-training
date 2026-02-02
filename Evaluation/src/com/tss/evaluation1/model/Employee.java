package com.tss.evaluation1.model;

public class Employee {

    private static int idCounter = 1;

    private final int id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.id = idCounter++;
        setName(name);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Only letters and spaces allowed.");
        }
    }

    public void setSalary(double salary) {
        if (isValidSalary(salary)) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be greater than 0.");
        }
    }

    private boolean isValidName(String name) {
        return name != null && !name.isBlank() && name.matches("[a-zA-Z ]+");
    }

    private boolean isValidSalary(double salary) {
        return salary > 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
