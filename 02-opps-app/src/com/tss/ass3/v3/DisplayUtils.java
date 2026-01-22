package com.tss.ass3.v3;

public class DisplayUtils {

    public static void printCourseTable(Course[] courses) {
        System.out.println("\\n----------------- COURSE LIST -----------------");
        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NAME", "FEES", "DURATION");
        System.out.println("----------------------------------------------");

        for (Course c : courses) {
            if (c != null) {
                System.out.printf("%-5d %-20s %-10.2f %-10d%n",
                        c.getId(), c.getName(), c.getFees(), c.getDuration());
            }
        }
        System.out.println("----------------------------------------------");
    }

    public static void printStudentProfile(Student s) {
        System.out.println("\\n---------------- STUDENT PROFILE ----------------");
        System.out.println("ID           : " + s.getId());
        System.out.println("Name         : " + s.getName());
        System.out.println("Total Fees   : " + s.getTotalFees());
        System.out.println("Fees Paid    : " + s.getFeesPaid());
        System.out.println("Pending Fees : " + s.getPendingFees());

        System.out.println("\\nCourses Enrolled:");
        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NAME", "FEES", "DURATION");
        System.out.println("----------------------------------------------");

        Course[] courses = s.getCourses();
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

        System.out.println("----------------------------------------------");
    }

    public static void printStudentCoursesOnly(Student s) {
        System.out.println("\n----------- COURSES OF " + s.getName().toUpperCase() + " -----------");
        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NAME", "FEES", "DURATION");
        System.out.println("----------------------------------------------");
        Course[] courses = s.getCourses();
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

        System.out.println("----------------------------------------------");
    }


}
