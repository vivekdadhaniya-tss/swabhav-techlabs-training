package com.tss;

public class Student {

    private final StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }
    public double calculatePercentage() {
        return studentService.getTotalMarks() / (double) studentService.getTotalStudents();
    }
}
