package com.tss.filehandling;

import java.io.Serializable;

class Student implements Serializable {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}