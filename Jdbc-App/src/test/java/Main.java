import com.tss.controller.StudentController;
import com.tss.controller.CourseController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Assign Course to Student");
            System.out.println("4. Read all students");
            System.out.println("5. Read all courses");
            System.out.println("6. Read students of particular course");
            System.out.println("7. Read Courses of particular student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                int ch = scan.nextInt();
                scan.nextLine();

                switch (ch) {
                    case 1 -> studentController.addNewStudent();
                    case 2 -> courseController.addNewCourse();
                    case 3 -> studentController.assignCourseToStudent();
                    case 4 -> studentController.getAllStudents();
                    case 5 -> courseController.getAllCourses();
                    case 6 -> courseController.getStudentsByCourse();
                    case 7 -> studentController.getCoursesByStudent();
                    case 0 -> {
                        System.out.println("Exiting application...");
                        scan.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 0 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scan.nextLine(); // clear the invalid input from scanner
            }
        }
    }
}