package com.tss.controller;

import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.service.CourseService;
import com.tss.service.impl.CourseServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CourseController {

    private static Scanner scan = new Scanner(System.in);
    private CourseService courseService = new CourseServiceImpl();

    public void addNewCourse() {
        try {
            System.out.print("Enter course name: ");
            String name = scan.next();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Error: Course name cannot be empty.");
                return;
            }

            System.out.print("Enter course fees: ");
            double fees = scan.nextDouble();
            scan.nextLine();
            if (fees < 0) {
                System.out.println("Error: Fees cannot be negative.");
                return;
            }

            Course course = new Course(name, fees);
            courseService.addNewCourse(course);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
            scan.nextLine();
        }
    }

    public void getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course c : courses) {
                System.out.println(c);
            }
        }
    }

    public void getStudentsByCourse() {
        try {
            System.out.print("Enter Course Id: ");
            int courseId = scan.nextInt();
            if (courseId <= 0) {
                System.out.println("Error: Course ID must be positive.");
                return;
            }

            List<Student> students = courseService.getStudentsByCourse(courseId);
            if (students.isEmpty()) {
                System.out.println("No students enrolled in this course.");
            } else {
                for (Student s : students) {
                    System.out.println(s);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
            scan.nextLine();
        }
    }
}