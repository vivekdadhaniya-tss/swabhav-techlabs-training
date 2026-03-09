package com.tss.repository;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.util.List;

public interface CourseRepository {

    void addNewCourse(Course course);

    List<Course> getAllCourses();

    List<Student> getStudentsByCourse(int courseId);
}