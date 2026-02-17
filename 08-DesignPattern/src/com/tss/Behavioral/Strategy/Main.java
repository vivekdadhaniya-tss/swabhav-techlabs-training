package com.tss.Behavioral.Strategy;

public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee("Vivek", new DeveloperRole());

        emp.performWork();
        System.out.println("Access FINANCE_SYSTEM: " + emp.requestAccess("FINANCE_SYSTEM"));
        System.out.println("Approve 2000: " + emp.requestApproval(2000));

        System.out.println("\n--- Promotion to Manager ---\n");

        emp.changeRole(new ManagerRole());

        emp.performWork();
        System.out.println("Access FINANCE_SYSTEM: " + emp.requestAccess("FINANCE_SYSTEM"));
        System.out.println("Approve 2000: " + emp.requestApproval(2000));
    }
}
