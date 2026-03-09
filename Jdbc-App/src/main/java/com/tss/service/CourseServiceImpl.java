package com.tss.service;

import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.repository.CourseRepository;
import com.tss.repository.CourseRepositoryImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public void addNewCourse(Course course) {
        courseRepository.addNewCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public List<Student> getStudentsByCourse(int courseId) {
        return courseRepository.getStudentsByCourse(courseId);
    }
}