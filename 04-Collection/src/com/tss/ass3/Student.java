package com.tss.ass3;

public class Student implements Comparable<Student> {

    private int id;
    private int rollNo;
    private String name;

    public Student(int id, int rollNo, String name) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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
                "id=" + id +
                ", rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.id;
    }
}
