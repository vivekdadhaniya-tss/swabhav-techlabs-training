package com.tss.ass3.v4.service;
import com.tss.ass3.v4.util.DisplayUtils;
import com.tss.ass3.v4.util.InputUtils;
import com.tss.ass3.v4.model.*;

import java.util.Scanner;

import static com.tss.ass3.v4.util.Constants.*;

public class CourseService {

    static Scanner scan = new Scanner(System.in);

    private Course[] courses = new Course[MAX_COURSES];
    private int availableCourseCount = 0;

    public Course[] getCourses() {
        return courses;
    }

    public int getAvailableCourseCount() {
        return availableCourseCount;
    }

    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course != null && course.getId() == id) return course;
        }
        return null;
    }

    public void createCourses() {

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

    public void displayAllCourses() {
        if (availableCourseCount == 0) {
            System.out.println("No courses available. Create courses first.");
            return;
        }
        DisplayUtils.printCourseTable(courses);
    }
}
