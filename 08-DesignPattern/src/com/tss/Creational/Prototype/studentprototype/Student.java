package com.tss.Creational.Prototype.studentprototype;

public class Student implements Prototype<Student> {

    private String name;
    private Subject subject;

    public Student(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    // shallow copy
    public Student shallowCopy() {
        return new Student(this.name, this.subject);    // shares subject reference
    }

    // deep copy
    @Override
    public Student clone() {
        return new Student(this.name, this.subject.clone());    // clone subject (and mark)
    }

    @Override
    public String toString() {
        return name + " -> " + subject;
    }
}
