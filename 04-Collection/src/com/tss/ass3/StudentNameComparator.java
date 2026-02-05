package com.tss.ass3;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
