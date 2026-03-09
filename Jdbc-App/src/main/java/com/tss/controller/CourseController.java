package com.tss.controller;

import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.service.CourseService;
import com.tss.service.CourseServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CourseController {

    private static Scanner scan = new Scanner(System.in);

    private CourseService courseService = new CourseServiceImpl();

    public void addNewCourse() {
        System.out.print("Enter course name: ");
        String name = scan.next();
        System.out.print("Enter course fees: ");
        double fees = scan.nextDouble();

        Course course = new Course(name, fees);
        courseService.addNewCourse(course);
    }

    public void getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void getStudentsByCourse() {
        System.out.print("Enter Course Id: ");
        int courseId = scan.nextInt();

        List<Student> students = courseService.getStudentsByCourse(courseId);
        for (Student s : students) {
            System.out.println(s);
        }
    }
}