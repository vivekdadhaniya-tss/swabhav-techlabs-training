package com.tss.Creational.Prototype.deepcopy;

public class PrototypeDeepCopyDemo {
    public static void main(String[] args) {
        SecurityPolicy policy = new SecurityPolicy("Level 2");
        IDCardDeep template = new IDCardDeep("TSS Company", "Trackwizz", policy, "Template");

        IDCardDeep emp1 = template.clone();
        emp1.setEmployeeName("John");
        emp1.setSecurityLevel("Level 3");

        IDCardDeep emp2 = template.clone();
        emp2.setEmployeeName("Alice");

        System.out.println("---- Template Card ----");
        template.showCard(); // Security level stays Level 2
        System.out.println("---- Employee 1 Card ----");
        emp1.showCard();
        System.out.println("---- Employee 2 Card ----");
        emp2.showCard();
    }
}
