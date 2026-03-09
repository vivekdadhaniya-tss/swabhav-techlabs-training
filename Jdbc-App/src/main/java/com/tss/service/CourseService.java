package com.tss.service;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.util.List;

public interface CourseService {

    void addNewCourse(Course course);

    List<Course> getAllCourses();

    List<Student> getStudentsByCourse(int courseId);
}