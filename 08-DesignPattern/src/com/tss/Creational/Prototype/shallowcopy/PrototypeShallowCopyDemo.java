package com.tss.Creational.Prototype.shallowcopy;

public class PrototypeShallowCopyDemo {
    public static void main(String[] args) {
        SecurityPolicy policy = new SecurityPolicy("Level 2");
        IDCardShallow template = new IDCardShallow("TSS Company", "Trackwizz", policy, "Template");

        IDCardShallow emp1 = template.clone();
        emp1.setEmployeeName("John");
        emp1.setSecurityLevel("Level 3");

        IDCardShallow emp2 = template.clone();
        emp2.setEmployeeName("Alice");

        System.out.println("---- Template Card ----");
        template.showCard();
        System.out.println("---- Employee 1 Card ----");
        emp1.showCard();
        System.out.println("---- Employee 2 Card ----");
        emp2.showCard();
    }
}
