package com.tss.ass2.test;

import com.tss.ass2.model.Course;
import com.tss.ass2.model.StudentProfile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner scan = new Scanner(System.in);
    static StudentProfile[] students;
    static int maxStudents;
    static int currentStudents = 0;

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.print("Enter number of students (max 10): ");
                maxStudents = scan.nextInt();
                scan.nextLine();

                if (maxStudents <= 0 || maxStudents > 10) {
                    System.out.println("Enter value between 1 and 10");
                    continue;
                }
                students = new StudentProfile[maxStudents];
                break;

            } catch (InputMismatchException e) {
                System.out.println("Enter integer value only.");
                scan.nextLine();
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("""
            
            === Student Management ===
            1. Add Student
            2. Add course
            3. Update course
            4. Pay Fees
            5. Show Pending Fees
            6. Display Student
            7. Display All Students
            8. Display All Course
            9. Exit
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
                case 1 -> createStudent();
                case 2 -> createCourse();
                case 3 -> updateCourse();
                case 4 -> payFees();
                case 5 -> showPendingFees();
                case 6 -> displayStudent();
                case 7 -> displayAllStudents();
                case 8 -> displayAllCourses();
                case 9 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
        scan.close();
    }

    private static StudentProfile selectStudent() {
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
//                if (choice == 0) return null;
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

    private static void createStudent() {

        if (currentStudents >= maxStudents) {
            System.out.println("Maximum students reached.");
            return;
        }

        StudentProfile student = new StudentProfile();

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

        addCourseToStudent(student);

        while (true) {
            try {
                System.out.print("Enter Fees Paid: ");
                double paid = scan.nextDouble();
                scan.nextLine();
                if (paid <= 0) {
                    System.out.println("Payment amount must be greater than 0.");
                    continue;
                }
                double pendingFees = student.getTotalFees() - student.getFeesPaid();
                if (paid > pendingFees) {
                    System.out.println("You only have " + pendingFees + " rs pending, not " + paid + " rs.");
                    continue;
                }
                student.setFeesPaid(paid);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid amount.");
                scan.nextLine();
            }
        }

        students[currentStudents++] = student;
        System.out.println("Student added successfully.");
    }

    private static void addCourseToStudent(StudentProfile student) {
        int numberOfCourses;

        while (true) {
            try {
                System.out.print("How many courses do you want to enroll (1 to 3): ");
                numberOfCourses = scan.nextInt();
                scan.nextLine();

                if (numberOfCourses < 1 || numberOfCourses > 3) {
                    System.out.println("You can enroll minimum 1 and maximum 3 courses only.");
                    continue;
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.nextLine();
            }
        }

        for (int i = 1; i <= numberOfCourses; i++) {

            System.out.println("\nEnter details for Course " + i);

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
            student.setCourse(new Course(courseName, fees, duration));
        }
        System.out.println(numberOfCourses + " courses added successfully.");

    }

    private static void createCourse() {
        StudentProfile student = selectStudent();

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Course[] courses = student.getCourses();

        int count = 0;
        for (Course c : courses) {
            if (c != null) count++;
        }

        if (count >= 3) {
            System.out.println("Student already enrolled in 3 courses.");
            return;
        }

        try {
            System.out.print("Enter Course Name: ");
            String name = scan.nextLine();

            if (name.isBlank() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid course name.");
                return;
            }

            System.out.print("Enter Course Fees: ");
            double fees = scan.nextDouble();

            if (fees <= 0) {
                System.out.println("Fees must be positive.");
                return;
            }

            System.out.print("Enter Course Duration (months): ");
            int duration = scan.nextInt();
            scan.nextLine();

            if (duration <= 0) {
                System.out.println("Duration must be positive.");
                return;
            }

            Course course = new Course(name, fees, duration);
            student.setCourse(course);

            System.out.println("Course added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }

    }

    private static void updateCourse() {

        StudentProfile student = selectStudent();
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Course[] courses = student.getCourses();

        int courseCount = 0;
        for (Course c : courses) {
            if (c != null) courseCount++;
        }

        if (courseCount == 0) {
            System.out.println("No courses available to update.");
            return;
        }

        System.out.println("Select a course to update:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println((i + 1) + ". " + courses[i].getName());
        }

        int choice;
        while (true) {
            try {
                System.out.print("Enter choice: ");
                choice = scan.nextInt();
                scan.nextLine();

                if (choice < 1 || choice > courseCount) {
                    System.out.println("Invalid selection.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.");
                scan.nextLine();
            }
        }

        try {
            System.out.print("Enter New Course Name: ");
            String name = scan.nextLine();
            if (name.isBlank() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid course name.");
                return;
            }

            System.out.print("Enter New Course Fees: ");
            double fees = scan.nextDouble();
            if (fees <= 0) {
                System.out.println("Fees must be positive.");
                return;
            }

            System.out.print("Enter New Course Duration (months): ");
            int duration = scan.nextInt();
            scan.nextLine();

            if (duration <= 0) {
                System.out.println("Duration must be positive.");
                return;
            }

//            courses[choice - 1] = new Course(name, fees, duration);
            student.updateCourse(choice - 1, new Course(name, fees, duration));

            System.out.println("Course updated successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }
    }


    private static void payFees() {
        StudentProfile student = selectStudent();

        if (student == null) {
            System.out.println("Student not found.");
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
        StudentProfile student = selectStudent();
        if (student != null)
            System.out.println("Pending Fees: " + student.getPendingFees());
        else
            System.out.println("Student not found.");
    }

    private static void displayStudent() {
        StudentProfile student = selectStudent();
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

    private static void displayAllCourses() {
        StudentProfile student = selectStudent();
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

}
