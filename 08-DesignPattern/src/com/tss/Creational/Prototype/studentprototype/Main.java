package com.tss.Creational.Prototype.studentprototype;

public class Main {
    public static void main(String[] args) {
        Mark mark = new Mark(95);
        Subject subject = new Subject("Math", mark);
        Student student1 = new Student("Vihaan", subject);

        // shallow copy
        Student student2 = student1.shallowCopy();
        student2.setName("Aryan");
        student2.getSubject().getMark().setScore(50);

        System.out.println("After shallow clone:");
        System.out.println(student1);   // Vihaan -> Math -> Mark: 50
        System.out.println(student2);   // Aryan -> Math -> Mark: 50


        // deep copy
        Student student3 = student1.clone();
        student3.setName("Rohan");
        student3.getSubject().getMark().setScore(80);
        System.out.println("\nAfter deep clone:");
        System.out.println(student1);   // Vihaan -> Math -> Mark: 50
        System.out.println(student3);   // Rohan -> Math -> Mark: 80

    }
}
