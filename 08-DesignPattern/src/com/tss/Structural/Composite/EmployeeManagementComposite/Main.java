package com.tss.Structural.Composite.EmployeeManagementComposite;

public class Main {
    public static void main(String[] args) {

        // Developers (Leaf)
        Developer dev1 = new Developer("Aarav", 50000);
        Developer dev2 = new Developer("Vihaan", 60000);
        Developer dev3 = new Developer("Anaya", 55000);

        // Managers (Composite)
        Manager manager1 = new Manager("Rohan", 100000);
        Manager manager2 = new Manager("Ishita", 120000);
        Manager manager3 = new Manager("Kabir", 90000);

        // Build hierarchy
        manager1.addEmployee(dev1);
        manager1.addEmployee(dev2);

        manager3.addEmployee(dev3);
        manager2.addEmployee(manager3);

        // CEO (Top-level Composite)
        Manager ceo = new Manager("Sagar (CEO)", 200000);
        ceo.addEmployee(manager1);
        ceo.addEmployee(manager2);

        ceo.showDetails(0);
    }
}
