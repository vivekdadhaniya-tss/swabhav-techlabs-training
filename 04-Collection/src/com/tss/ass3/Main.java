package com.tss.ass3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

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


        System.out.println("\n\nSort using Method Reference:");
        List<Student2> students4 = new ArrayList<>();

        students4.add(new Student2(1, 101, "vivek"));
        students4.add(new Student2(4, 104, "smit"));
        students4.add(new Student2(3, 103, "jay"));
        students4.add(new Student2(2, 102, "kelvin"));

//        students4.sort(Main::compareByRollNo);
//        students4.forEach(System.out::println);

        students4.sort((s1, s2) -> s1.getRollNo() - s2.getRollNo());
        students4.forEach(s -> System.out.println(s));

    }

    public static int compareByRollNo(Student2 s1, Student2 s2) {
        return s1.getRollNo() - s2.getRollNo();
    }

}
