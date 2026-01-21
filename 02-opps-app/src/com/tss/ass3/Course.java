package com.tss.ass3;

public class Course {

    private static int idCounter = 0;
    private int courseId;
    private String name;
    private double fees;
    private int duration;

    public Course(String name, double fees, int duration) {
        this.courseId = ++idCounter;
        this.name = name;
        this.fees = fees;
        this.duration = duration;
    }

    public int getId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void displayCourse() {
        System.out.println("ID      : " + courseId);
        System.out.println("Name    : " + name);
        System.out.println("Fees    : " + fees);
        System.out.println("Duration: " + duration + " months");
        System.out.println("---------------------------");
    }
}