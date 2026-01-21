package com.tss.ass3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner scan = new Scanner(System.in);
    static Student[] students;
    static Course[] courses = new Course[5];
    static int availableCourseCount = 0;
    static int maxStudents = 10;
    static int currentStudents = 0;

    public static void main(String[] args) {

        students = new Student[maxStudents];

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

            int choice;
            while(true) {
                try {
                    System.out.print("Choose option: ");
                    choice = scan.nextInt();
                    scan.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input must be a number. Try again.");
                    scan.nextLine();
                }
            }

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

    private static void createCourses() {

        if (availableCourseCount == 5) {
            System.out.println("All 5 courses already created.");
            return;
        }

        while (availableCourseCount < 5) {

            System.out.println("\nEnter details for Course " + (availableCourseCount + 1));

            String courseName;
            double fees;
            int duration;

            // Course Name
            while (true) {
                System.out.print("Course Name: ");
                courseName = scan.nextLine();

                if (courseName.isBlank() || !courseName.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid course name. Only letters allowed.");
                    continue;
                }
                break;
            }

            // Course Fees
            while (true) {
                try {
                    System.out.print("Course Fees: ");
                    fees = scan.nextDouble();
                    scan.nextLine();

                    if (fees <= 0) {
                        System.out.println("Fees must be greater than 0.");
                        continue;
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid fee amount.");
                    scan.nextLine();
                }
            }

            // Course Duration
            while (true) {
                try {
                    System.out.print("Course Duration (months): ");
                    duration = scan.nextInt();
                    scan.nextLine();

                    if (duration <= 0) {
                        System.out.println("Duration must be greater than 0.");
                        continue;
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid duration.");
                    scan.nextLine();
                }
            }
            courses[availableCourseCount++] = new Course(courseName, fees, duration);
            System.out.println("Course " + availableCourseCount + " added successfully.");
        }
        System.out.println("\nAll 5 available courses created successfully.");
    }

    private static void createStudent() {

        if (currentStudents >= maxStudents) {
            System.out.println("Maximum students reached.");
            return;
        }

        Student student = new Student();

        while (true) {
            try {
                System.out.print("Enter Name: ");
                String name = scan.nextLine();
                if(name == null || name.trim().isBlank()) {
                    System.out.println("Name cannot be empty");
                    continue;
                }
                if(!name.matches("[a-zA-Z ]+")) {
                    System.out.println("Name must contain only letters");
                    continue;
                }
                student.setName(name);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        students[currentStudents++] = student;
        System.out.println("Student added successfully.");
    }

    private static Student selectStudent() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return null;
        }

        System.out.println("Select a student:");
        for (int i = 0; i < currentStudents; i++) {
            System.out.println((i + 1) + ". " + students[i].getName());
        }

        int choice;
        while (true) {
            try {
                System.out.print("Enter number: ");
                choice = scan.nextInt();
                scan.nextLine();
                if (choice < 1 || choice > currentStudents) {
                    System.out.println("Invalid selection.");
                    continue;
                }
                return students[choice - 1];
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.");
                scan.nextLine();
            }
        }
    }

    private static Student studentFindById(int id) {
        for(int i = 0; i < currentStudents; i++) {
            if(students[i].getId() == id)
                return students[i];
        }
        return null;
    }

    private static void addCourses() {

        if(availableCourseCount == 0) {
            System.out.println("No courses are created yet. Create courses first.");
            return;
        }

        if (currentStudents == 0) {
            System.out.println("No students available. Create student first for adding course.");
            return;
        }

        for(int i = 0; i < currentStudents; i++)
            System.out.println(students[i].getId() + " - " + students[i].getName());

        System.out.println("Select the student in which you want to add course: ");
        int studentId = scan.nextInt();
        Student student = studentFindById(studentId);

        if(student == null) {
            System.out.println("No student available of id: " + studentId);
            return;
        }

        if(student.getCourseCount() == 3) {
            System.out.println("You enroll 3 courses. Now you cannot enroll any courses.");
            return;
        }

        int numberOfCourses;

        while (true) {
            try {
                System.out.print("How many courses do you want to enroll (1 to 3): ");
                numberOfCourses = scan.nextInt();
                scan.nextLine();

                if(numberOfCourses < 1) {
                    System.out.println("Enter valid value.");
                    continue;
                }

                if(numberOfCourses + student.getCourseCount() > 3) {
                    System.out.println("You can enroll max 3 courses per student.\nCurrently you enroll " + student.getCourseCount() + "courses.\nNow you only enroll " + (3-student.getCourseCount()) + " courses." );
                    continue;
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.nextLine();
            }
        }

        for (Course course : courses)
            System.out.println(course.getId() + " - " + course.getName());
        System.out.println("Select the course in which you want to add in student: ");


        while(numberOfCourses > 0) {
            System.out.print("Add course: ");
            int courseId = scan.nextInt();
            Course course = courseFindById(courseId);
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
        }
        System.out.println("Courses added successfully.");
    }

    private static Course courseFindById(int id) {
        for (Course course : courses) {
            if (course != null && course.getId() == id)
                return course;
        }
        return null;
    }

    private static void payFees() {

        if(availableCourseCount == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }

        Student student = selectStudent();

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if(student.getCourseCount() == 0) {
            System.out.println("No courses enroll by student.");
            return;
        }

        if(student.getPendingFees() == 0) {
            System.out.println("You paid all fees.");
            return;
        }

        while (true) {
            try {
                System.out.print("Enter amount: ");
                double amount = scan.nextDouble();
                scan.nextLine();
                if (amount <= 0) {
                    System.out.println("Payment amount must be greater than 0.");
                    continue;
                }
                double pendingFees = student.getTotalFees() - student.getFeesPaid();
                if (amount > pendingFees) {
                    System.out.println("You only have " + pendingFees + " rs pending, not " + amount + " rs.");
                    continue;
                }
                student.payFees(amount);
                System.out.println("Payment successful.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid amount.");
                scan.nextLine();
            }
        }
    }

    private static void showPendingFees() {
        if(availableCourseCount == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }
        Student student = selectStudent();
        if (student != null)
            System.out.println("Pending Fees: " + student.getPendingFees());
        else
            System.out.println("Student not found.");
    }

    private static void displayStudent() {
        Student student = selectStudent();
        if (student != null)
            student.displayProfile();
        else
            System.out.println("Student not found.");
    }

    private static void displayAllStudents() {
        if (currentStudents == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < currentStudents; i++) {
            students[i].displayProfile();
        }
    }

    private static void displayAllStudentCourses() {
        if(availableCourseCount == 0) {
            System.out.println("No courses available for enroll. First create courses.");
            return;
        }
        Student student = selectStudent();
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Course[] courses = student.getCourses();

        System.out.println("Courses Enrolled:");

        boolean courseEnroll = false;

        for (Course course : courses) {
            if (course != null) {
                course.displayCourse();
                courseEnroll = true;
            }
        }

        if (!courseEnroll) {
            System.out.println("No courses enrolled.");
        }
    }

    private static void displayAllCourses() {
        if (availableCourseCount == 0) {
            System.out.println("No courses available. Create courses first.");
            return;
        }

        System.out.println("Available Courses:");
        for (int i = 0; i < availableCourseCount; i++) {
            courses[i].displayCourse();
        }
    }
}