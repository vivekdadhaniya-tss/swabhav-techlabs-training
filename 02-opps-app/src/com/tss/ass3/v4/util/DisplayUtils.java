package com.tss.ass3.v4.util;

import com.tss.ass3.v4.model.Course;
import com.tss.ass3.v4.model.Student;

public class DisplayUtils {

    /* ---------------- COURSE DISPLAY ---------------- */

    public static void printCourseTable(Course[] courses) {

        if (courses == null || courses.length == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n==================== COURSE LIST ====================");
        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NAME", "FEES", "DURATION");
        System.out.println("----------------------------------------------------");

        boolean found = false;

        for (Course c : courses) {
            if (c != null) {
                System.out.printf("%-5d %-20s %-10.2f %-10d%n",
                        c.getId(), c.getName(), c.getFees(), c.getDuration());
                found = true;
            }
        }

        if (!found)
            System.out.println("No courses to display.");

        System.out.println("====================================================");
    }

    /* ---------------- STUDENT PROFILE ---------------- */

    public static void printStudentProfile(Student s) {

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n================== STUDENT PROFILE ==================");
        System.out.println("ID           : " + s.getId());
        System.out.println("Name         : " + s.getName());
        System.out.printf("Total Fees   : %.2f%n", s.getTotalFees());
        System.out.printf("Fees Paid    : %.2f%n", s.getFeesPaid());
        System.out.printf("Pending Fees : %.2f%n", s.getPendingFees());

        System.out.println("\nCourses Enrolled:");
        printStudentCoursesTable(s);

        System.out.println("====================================================");
    }

    /* ---------------- STUDENT COURSES ONLY ---------------- */

    public static void printStudentCoursesOnly(Student s) {

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n=========== COURSES OF " + s.getName().toUpperCase() + " ===========");
        printStudentCoursesTable(s);
        System.out.println("====================================================");
    }

    /* ---------------- COMMON COURSE TABLE ---------------- */

    private static void printStudentCoursesTable(Student s) {

        Course[] courses = s.getCourses();

        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NAME", "FEES", "DURATION");
        System.out.println("----------------------------------------------------");

        boolean hasCourses = false;

        for (Course c : courses) {
            if (c != null) {
                System.out.printf("%-5d %-20s %-10.2f %-10d%n",
                        c.getId(), c.getName(), c.getFees(), c.getDuration());
                hasCourses = true;
            }
        }

        if (!hasCourses)
            System.out.println("No courses enrolled.");
    }
}
