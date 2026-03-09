package com.tss.service.impl;

import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.repository.CourseRepository;
import com.tss.repository.impl.CourseRepositoryImpl;
import com.tss.service.CourseService;

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