package com.tss.ass2.model;

import java.util.UUID;

public class StudentProfile {

    private final String studentId;
    private String name;
    private Course[] courses;
    private int courseCount;
    private double feesPaid;
    private double totalFees;

    public StudentProfile() {
        this.studentId = UUID.randomUUID().toString();
        this.courses = new Course[3];
    }

    public StudentProfile(String name) {
        this.studentId = UUID.randomUUID().toString();
        this.name = name;
        this.courses = new Course[3];
        this.courseCount = 0;
        this.feesPaid = 0;
        this.totalFees = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        courses[courseCount++] = course;
        totalFees += course.getFees();
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getPendingFees() {
        return  (totalFees - feesPaid);
    }

    public void displayProfile() {
        System.out.println("Student Id: " + studentId);
        System.out.println("Name: " + name);

        System.out.println("Courses Enrolled:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("  - " + courses[i].getName());
        }

        System.out.println("Total Fees: " + totalFees);
        System.out.println("Fees Paid: " + feesPaid);
        System.out.println("Remaining Fees: " + (totalFees - feesPaid));
        System.out.println("---------------------------");
    }

    public void updateCourse(int index, Course newCourse) {

        if (index < 0 || index >= courseCount) {
            System.out.println("Invalid course index");
            return;
        }

        Course oldCourse = courses[index];

        // Adjust total fees
        totalFees -= oldCourse.getFees();
        totalFees += newCourse.getFees();

        courses[index] = newCourse;
    }

}