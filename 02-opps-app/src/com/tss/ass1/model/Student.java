package com.tss.ass1.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private double feesPaid;
    private double totalFees;

    public Student() {

    }

    public Student(int id, String name, String course, double feesPaid, double totalFees) {
        setId(id);
        setName(name);
        setCourse(course);
        setFeesPaid(feesPaid);
        setTotalFees(totalFees);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must contain only letters");
        }
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        if(course == null || course.trim().isBlank()) {
            throw new IllegalArgumentException("Course cannot be empty");
        }
        if(!course.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Course must contain only letters");
        }
        this.course = course;
    }

    public double getPaidFees() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        if(feesPaid < 0) {
            throw new IllegalArgumentException("Paid fees cannot be negative");
        }
        if(this.totalFees > 0 && feesPaid > totalFees) {
            throw new IllegalArgumentException("Paid fees cannot exceed total fees");
        }
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        if (totalFees <= 0) {
            throw new IllegalArgumentException("Total fees must be positive.");
        }
        if (totalFees < feesPaid) {
            throw new IllegalArgumentException("Total fees must be greater or equal paid fees.");
        }
        this.totalFees = totalFees;
    }

    public void payFees(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0.");
        }

        double pendingFees = totalFees - feesPaid;

        if (amount > pendingFees) {
            throw new IllegalArgumentException(
                    "You only have " + pendingFees + " rs left, not " + amount + " rs."
            );
        }

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
        System.out.println("---------------------------");
    }
}