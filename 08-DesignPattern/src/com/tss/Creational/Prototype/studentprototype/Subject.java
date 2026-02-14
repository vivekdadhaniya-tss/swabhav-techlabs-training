package com.tss.Creational.Prototype.studentprototype;

public class Subject implements Prototype<Subject> {

    private String name;
    private Mark mark;

    public Subject(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    // shallow copy
    public Subject shallowCopy() {
        return new Subject(this.name, this.mark);   // shares mark reference
    }

    // deep copy
    @Override
    public Subject clone() {
        return new Subject(this.name, this.mark.clone());
    }

    @Override
    public String toString() {
        return name + " -> " + mark;
    }
}
