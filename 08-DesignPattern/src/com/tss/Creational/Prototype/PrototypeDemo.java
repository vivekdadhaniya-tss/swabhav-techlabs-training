package com.tss.Creational.Prototype;

public class PrototypeDemo {

    public static void main(String[] args) {

        // Step 1: Create a template ID card
        IDCard template = new IDCard(
                "TSS Company",
                "Trackwizz",
                "Level 2",
                "Template"
        );

        // Step 2: Clone template for Employee 1
        IDCard emp1 = template.clone();
        emp1.setEmployeeName("John");

        // Step 3: Clone template for Employee 2
        IDCard emp2 = template.clone();
        emp2.setEmployeeName("Alice");

        // Step 4: Print all cards
        System.out.println("---- Template Card ----");
        template.showCard();

        System.out.println("---- Employee 1 Card ----");
        emp1.showCard();

        System.out.println("---- Employee 2 Card ----");
        emp2.showCard();
    }
}
