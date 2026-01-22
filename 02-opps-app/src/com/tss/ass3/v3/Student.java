package com.tss.ass3.v3;

public class Student {

    private static int idCounter = 100;
    private int studentId;
    private String name;
    private Course[] courses;
    private int courseCount;
    private double feesPaid;
    private double totalFees;

    public Student() {
        this.studentId = ++idCounter;
        this.courses = new Course[3];
    }

    public int getId() {
        return studentId;
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

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourse(Course course) {
        if (courseCount >= courses.length) {
            System.out.println("Maximum course limit reached.");
            return;
        }
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

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getPendingFees() {
        return  (totalFees - feesPaid);
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