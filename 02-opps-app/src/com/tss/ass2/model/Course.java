package com.tss.ass2.model;

import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
    private double fees;
    private int duration;

    public Course(String name, double fees, int duration) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.fees = fees;
        this.duration = duration;
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
        System.out.println("Duration: " + duration + " days");
        System.out.println("---------------------------");
    }
}