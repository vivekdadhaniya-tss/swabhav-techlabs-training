package com.tss.Behavioral.Strategy;

public class Employee {

    private static int idCounter = 100;
    private int id;
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.id = ++idCounter;
        this.name = name;
        this.role = role;
    }

    public void changeRole(Role newRole) {
        this.role = newRole;
        System.out.println(name + " is now a " + newRole.getRoleName());
    }

    public void performWork() {
        role.performDuties();
    }

    public boolean requestAccess(String resource) {
        return role.canAccess(resource);
    }

    public boolean requestApproval(double amount) {
        return role.canApprove(amount);
    }
}
