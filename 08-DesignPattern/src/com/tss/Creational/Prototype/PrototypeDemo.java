package com.tss.Creational.Prototype;

public class PrototypeDemo {

    public static void main(String[] args) {

        IDCard template = new IDCard(
                "TSS Company",
                "Trackwizz",
                "Level 2",
                "Template"
        );

        IDCard emp1 = template.clone();
        emp1.setEmployeeName("John");

        IDCard emp2 = template.clone();
        emp2.setEmployeeName("Alice");

        System.out.println("---- Template Card ----");
        template.showCard();

        System.out.println("---- Employee 1 Card ----");
        emp1.showCard();

        System.out.println("---- Employee 2 Card ----");
        emp2.showCard();
    }
}
