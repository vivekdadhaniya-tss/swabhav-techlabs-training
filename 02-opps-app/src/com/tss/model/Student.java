package com.tss.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private double feesPaid;
    private double totalFees;

    public Student() {

    }

    public Student(int id, String name, String course, double feesPaid, double totalFees) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.feesPaid = feesPaid;
        this.totalFees = totalFees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getPaidFees() {
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
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Fees Paid: " + feesPaid);
        System.out.println("Total Fees: " + totalFees);
    }
}
