package com.tss.service;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    int addNewStudent(Student student);

    void assignCourse(int studentId, int courseId);

    List<Course> getCoursesByStudent(int studentId);
}
