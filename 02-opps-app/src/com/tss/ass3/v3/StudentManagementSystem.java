package com.tss.ass3.v3;

import java.util.Scanner;

public class StudentManagementSystem {

    private static final int MAX_COURSES = 5;
    private static final int MAX_STUDENTS = 10;

    private static int availableCourseCount = 0;
    private static int currentStudents = 0;

    private static final Scanner scan = new Scanner(System.in);
    private static final Student[] students = new Student[MAX_STUDENTS];
    private static final Course[] courses = new Course[MAX_COURSES];

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("""
                    
                    === Student Management ===
                    1. Create Courses
                    2. Add Student
                    3. Add course to Student
                    4. Pay Fees
                    5. Show Pending Fees
                    6. Display Student
                    7. Display All Students
                    8. Display Student Courses
                    9. Display All Courses
                    0. Exit
                    """);

            int choice = InputUtils.readIntInRange(scan, "Choose option: ", 0, 9);

            switch (choice) {
                case 1 -> createCourses();
                case 2 -> createStudent();
                case 3 -> addCourses();
                case 4 -> payFees();
                case 5 -> showPendingFees();
                case 6 -> displayStudent();
                case 7 -> displayAllStudents();
                case 8 -> displayAllStudentCourses();
                case 9 -> displayAllCourses();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
        scan.close();
    }

    private static Student selectStudent() {
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

    private static Student findStudentById(int id) {
        for (int i = 0; i < currentStudents; i++) {
            if (students[i].getId() == id) return students[i];
        }
        return null;
    }

    private static Course findCourseById(int id) {
        for (Course course : courses) {
            if (course != null && course.getId() == id) return course;
        }
        return null;
    }

    private static void createCourses() {

        if (availableCourseCount == MAX_COURSES) {
            System.out.println("All 5 courses already created.");
            return;
        }

        while (availableCourseCount < MAX_COURSES) {

            System.out.println("\nEnter details for Course " + (availableCourseCount + 1));

            String name = InputUtils.readName(scan, "Course Name: ");
            double fees = InputUtils.readPositiveDouble(scan, "Course Fees: ");
            int duration = InputUtils.readPositiveInt(scan, "Course Duration (months): ");
            
            courses[availableCourseCount++] = new Course(name, fees, duration);
            System.out.println("Course " + availableCourseCount + " added successfully.");
        }
        System.out.println("\nAll 5 available courses created successfully.");
    }

    private static void createStudent() {

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

    private static void addCourses() {

        if (availableCourseCount == 0) {
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
        for (Course course : courses)
            System.out.println(course.getId() + " - " + course.getName());

        while (numberOfCourses > 0) {
            int courseId = InputUtils.readPositiveInt(scan, "Add course ID: ");
            Course course = findCourseById(courseId);

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

    private static void payFees() {

        if (availableCourseCount == 0) {
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

    private static void showPendingFees() {
        if (availableCourseCount == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }
        Student student = selectStudent();
        if (student != null) System.out.println("Pending Fees: " + student.getPendingFees());
        else System.out.println("Student not found.");
    }

    private static void displayStudent() {
        Student student = selectStudent();
        if (student != null) DisplayUtils.printStudentProfile(student);
        else System.out.println("Student not found.");
    }

    private static void displayAllStudents() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < currentStudents; i++) {
            DisplayUtils.printStudentProfile(students[i]);
        }
    }

    private static void displayAllStudentCourses() {
        if (availableCourseCount == 0) {
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

    private static void displayAllCourses() {
        if (availableCourseCount == 0) {
            System.out.println("No courses available. Create courses first.");
            return;
        }
        DisplayUtils.printCourseTable(courses);
    }
}