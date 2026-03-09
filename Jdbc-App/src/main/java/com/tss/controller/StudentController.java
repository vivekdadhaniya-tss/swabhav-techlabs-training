package com.tss.controller;

import com.tss.entity.Address;
import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.service.AddressService;
import com.tss.service.impl.AddressServiceImpl;
import com.tss.service.StudentService;
import com.tss.service.impl.StudentServiceImpl;

import java.util.InputMismatchException;
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
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for(Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void addNewStudent() {
        try {
            System.out.print("Enter Student RollNumber: ");
            int rollNumber = scan.nextInt();
            if (rollNumber <= 0) {
                System.out.println("Error: Roll number must be positive.");
                return;
            }

            System.out.print("Enter Student name: ");
            String studentName = scan.next();
            if (studentName == null || studentName.trim().isEmpty()) {
                System.out.println("Error: Student name cannot be empty.");
                return;
            }

            System.out.print("Enter Student Age: ");
            int age = scan.nextInt();
            if (age <= 0 || age > 150) {
                System.out.println("Error: Please enter a valid age.");
                return;
            }

            Student student = new Student(rollNumber, studentName, age);
            int studentId = studentService.addNewStudent(student);

            if (studentId != -1) {
                System.out.print("Enter city name: ");
                String cityName = scan.next();
                System.out.print("Enter state name: ");
                String stateName = scan.next();
                System.out.print("Enter pincode: ");
                String pincode = scan.next();

                if (!cityName.isEmpty() && !stateName.isEmpty() && !pincode.isEmpty()) {
                    Address address = new Address(studentId, cityName, stateName, pincode);
                    addressService.addAddress(address);
                    System.out.println("Student and address added successfully.");
                } else {
                    System.out.println("Student added, but address fields were empty.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format. Please enter correct data types.");
            scan.nextLine();
        }
    }

    public void assignCourseToStudent() {
        try {
            System.out.print("Enter Student Id: ");
            int studentId = scan.nextInt();
            System.out.print("Enter Course Id: ");
            int courseId = scan.nextInt();

            if (studentId <= 0 || courseId <= 0) {
                System.out.println("Error: IDs must be positive.");
                return;
            }

            studentService.assignCourse(studentId, courseId);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
            scan.nextLine();
        }
    }

    public void getCoursesByStudent() {
        try {
            System.out.print("Enter Student Roll Number: ");
            int rollNumber = scan.nextInt();
            if (rollNumber <= 0) {
                System.out.println("Error: Roll number must be positive.");
                return;
            }

            List<Course> courses = studentService.getCoursesByStudent(rollNumber);
            if (courses.isEmpty()) {
                System.out.println("No courses found for this student.");
            } else {
                for(Course course : courses) {
                    System.out.println(course);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
            scan.nextLine();
        }
    }
}
