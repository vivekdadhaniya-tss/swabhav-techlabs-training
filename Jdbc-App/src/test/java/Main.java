import com.tss.controller.StudentController;
import com.tss.controller.CourseController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();

        while (true) {
            System.out.println("""
                    
                    1. Add Student
                    2. Add Course
                    3. Assign Course to Student
                    4. Read all students
                    5. Read all courses
                    6. Read students of particular course
                    7. Read Courses of particular student
                    0. Exit
                    """);

            System.out.print("Enter choice: ");
            int ch = scan.nextInt();

            switch (ch) {
                case 1 -> studentController.addNewStudent();
                case 2 -> courseController.addNewCourse();
                case 3 -> studentController.assignCourseToStudent();
                case 4 -> studentController.getAllStudents();
                case 5 -> courseController.getAllCourses();
                case 6 -> courseController.getStudentsByCourse();
                case 7 -> studentController.getCoursesByStudent();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}