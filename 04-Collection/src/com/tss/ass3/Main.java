package com.tss.ass3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, 101, "vivek"));
        students.add(new Student(4, 104, "smit"));
        students.add(new Student(3, 103, "jay"));
        students.add(new Student(2, 102, "kelvin"));

        Collections.sort(students);

        System.out.println("Using Comparable: ");
        for(Student student : students)
            System.out.println(student);

        List<Student2> students2 = new ArrayList<>();

        students2.add(new Student2(1, 101, "vivek"));
        students2.add(new Student2(4, 104, "smit"));
        students2.add(new Student2(3, 103, "jay"));
        students2.add(new Student2(2, 102, "kelvin"));

        Collections.sort(students2, new StudentNameComparator());

        System.out.println("\nUsing Comparator: ");
        for(Student2 student : students2)
            System.out.println(student);


        List<Student2> students3 = new ArrayList<>();

        students3.add(new Student2(1, 101, "vivek"));
        students3.add(new Student2(4, 104, "smit"));
        students3.add(new Student2(3, 103, "jay"));
        students3.add(new Student2(2, 102, "kelvin"));

        students2.sort(
                Comparator.comparing(Student2::getName)
        );
        System.out.println("\nUsing Comparator Direct: ");
        for(Student2 student : students2)
            System.out.println(student);
    }
}
