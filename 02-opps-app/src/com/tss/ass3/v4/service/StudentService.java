package com.tss.ass3.v4.service;

import com.tss.ass3.v4.model.Course;
import com.tss.ass3.v4.model.Student;
import com.tss.ass3.v4.util.DisplayUtils;
import com.tss.ass3.v4.util.InputUtils;

import java.util.Scanner;

import static com.tss.ass3.v4.util.Constants.*;

public class StudentService {

    static Scanner scan = new Scanner(System.in);

    private final Student[] students = new Student[MAX_STUDENTS];
    private int currentStudents = 0;

    private final CourseService courseService;

    public StudentService(CourseService courseService) {
        this.courseService = courseService;
    }

    public Student selectStudent() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return null;
        }

        System.out.println("Select a student:");
        for (int i = 0; i < currentStudents; i++) {
            System.out.println((i + 1) + ". " + students[i].getName() + " (ID: " + students[i].getId() + ")");
        }

        int choice = InputUtils.readIntInRange(
                scan, "Select student: ", 1, currentStudents);

        return students[choice - 1];
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < currentStudents; i++) {
            if (students[i].getId() == id) return students[i];
        }
        return null;
    }

    public void createStudent() {

        if (currentStudents >= MAX_STUDENTS) {
            System.out.println("Maximum students reached.");
            return;
        }

        Student student = new Student();

        String name = InputUtils.readName(scan, "Enter Name: ");
        student.setName(name);

        students[currentStudents++] = student;
        System.out.println("Student added successfully.");
    }

    public void addCourseToStudent() {

        if (courseService.getAvailableCourseCount() == 0) {
            System.out.println("No courses are created yet. Create courses first.");
            return;
        }

        if (currentStudents == 0) {
            System.out.println("No students available. Create student first for adding course.");
            return;
        }

        System.out.println("Available Students:");
        for (int i = 0; i < currentStudents; i++)
            System.out.println(students[i].getId() + " - " + students[i].getName());

        int studentId = InputUtils.readPositiveInt(scan, "Enter Student ID:");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("No student available of id: " + studentId);
            return;
        }

        if (student.getCourseCount() == MAX_COURSES) {
            System.out.println("You enroll " + MAX_COURSES + "courses. Now you cannot enroll any courses.");
            return;
        }

        int numberOfCourses;

        while (true) {
            numberOfCourses = InputUtils.readIntInRange(scan,
                    "How many courses do you want to enroll (1 to 3): ", 1, 3);

            if (numberOfCourses + student.getCourseCount() > 3) {
                System.out.println("You can enroll max 3 courses per student." +
                        "\nCurrently you enroll " + student.getCourseCount() + "courses." +
                        "\nNow you only enroll " + (3 - student.getCourseCount()) + " courses.");
                continue;
            }
            break;
        }

        System.out.println("Available Courses:");
        for (Course course : courseService.getCourses())
            System.out.println(course.getId() + " - " + course.getName());

        while (numberOfCourses > 0) {
            int courseId = InputUtils.readPositiveInt(scan, "Add course ID: ");
            Course course = courseService.findCourseById(courseId);

            if (course == null) {
                System.out.println("Invalid course ID.");
                continue;
            }

            // duplicate course check
            boolean alreadyEnrolled = false;
            for (Course c : student.getCourses()) {
                if (c != null && c.getId() == course.getId()) {
                    System.out.println("Course already enrolled.");
                    alreadyEnrolled = true;
                    break;
                }
            }

            if (alreadyEnrolled) {
                continue;
            }

            student.setCourse(course);
            numberOfCourses--;
            System.out.println("Course added successfully.");
        }
        System.out.println("All selected courses added successfully.");
    }

    public void payFees() {

        if (courseService.getAvailableCourseCount() == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }

        Student student = selectStudent();

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (student.getCourseCount() == 0) {
            System.out.println("No courses enroll by student.");
            return;
        }

        if (student.getPendingFees() == 0) {
            System.out.println("You paid all fees.");
            return;
        }

        while (true) {
            double amount = InputUtils.readPositiveDouble(scan, "Enter amount");
            double pendingFees = student.getPendingFees();

            if (amount > pendingFees) {
                System.out.println("You only have " + pendingFees + " rs pending.");
                continue;
            }
            student.payFees(amount);
            System.out.println("Payment successful.");
            break;
        }
    }

    public void showPendingFees() {
        if (courseService.getAvailableCourseCount() == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }
        Student student = selectStudent();
        if (student != null) System.out.println("Pending Fees: " + student.getPendingFees());
        else System.out.println("Student not found.");
    }

    public void displayStudent() {
        Student student = selectStudent();
        if (student != null) DisplayUtils.printStudentProfile(student);
        else System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < currentStudents; i++) {
            DisplayUtils.printStudentProfile(students[i]);
        }
    }

    public void displayAllStudentCourses() {
        if (courseService.getAvailableCourseCount() == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }
        Student student = selectStudent();
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        DisplayUtils.printStudentCoursesOnly(student);
    }
}