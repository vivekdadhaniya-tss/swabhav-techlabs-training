package com.tss.ass3.v4;

import com.tss.ass3.v4.service.CourseService;
import com.tss.ass3.v4.service.StudentService;
import com.tss.ass3.v4.util.InputUtils;

import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService(courseService);

        boolean running = true;

        while (running) {
            System.out.println("""
                             
                            =====================================
                               STUDENT MANAGEMENT SYSTEM
                            =====================================
                            1. Create Courses
                            2. Add Student
                            3. Enroll Courses to Student
                            4. Pay Student Fees
                            5. Show Student Pending Fees
                            6. Display Student Profile
                            7. Display All Students
                            8. Display Student Courses
                            9. Display All Courses
                            0. Exit Application
                            -------------------------------------
                            """);

            int choice = InputUtils.readIntInRange(scan, "Choose option: ", 0, 9);

            switch (choice) {
                case 1 -> courseService.createCourses();
                case 2 -> studentService.createStudent();
                case 3 -> studentService.addCourseToStudent();
                case 4 -> studentService.payFees();
                case 5 -> studentService.showPendingFees();
                case 6 -> studentService.displayStudent();
                case 7 -> studentService.displayAllStudents();
                case 8 -> studentService.displayAllStudentCourses();
                case 9 -> courseService.displayAllCourses();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
        scan.close();
    }
}