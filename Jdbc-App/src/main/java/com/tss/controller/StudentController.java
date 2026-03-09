package com.tss.controller;

import com.tss.entity.Address;
import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.service.AddressService;
import com.tss.service.AddressServiceImpl;
import com.tss.service.StudentService;
import com.tss.service.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private static Scanner scan = new Scanner(System.in);

    private StudentService studentService = new StudentServiceImpl();
    private AddressService addressService = new AddressServiceImpl();

//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    public void getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void addNewStudent() {

        System.out.print("Enter Student RollNumber: ");
        int rollNumber = scan.nextInt();
        System.out.print("Enter Student name: ");
        String studentName = scan.next();
        System.out.print("Enter Student Age: ");
        int age = scan.nextInt();

        Student student = new Student(rollNumber, studentName, age);
        int studentId = studentService.addNewStudent(student);

        System.out.print("Enter city name: ");
        String cityName = scan.next();
        System.out.print("Enter state name: ");
        String stateName = scan.next();
        System.out.print("Enter pincode: ");
        String pincode = scan.next();

        Address address = new Address(studentId, cityName, stateName, pincode);
        addressService.addAddress(address);

        System.out.println("Student added successfully");
    }

    public void assignCourseToStudent() {
        System.out.print("Enter Student Id: ");
        int studentId = scan.nextInt();
        System.out.print("Enter Course Id: ");
        int courseId = scan.nextInt();

        studentService.assignCourse(studentId, courseId);
        System.out.println("Course assigned successfully");
    }

    public void getCoursesByStudent() {
        System.out.print("Enter Student Roll Number: ");
        int  studentId = scan.nextInt();
        List<Course> courses = studentService.getCoursesByStudent(studentId);
        for(Course course : courses) {
            System.out.println(course);
        }
    }
}
