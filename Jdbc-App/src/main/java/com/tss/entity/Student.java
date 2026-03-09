package com.tss.entity;

public class Student {
    private int studentId;
    private int rollNumber;
    private int age;
    private String name;

    public Student(int studentId, int rollNumber, int age, String name) {
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
    }

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", rollNumber=" + rollNumber +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
