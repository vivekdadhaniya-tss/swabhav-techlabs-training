package com.tss.repository;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getAllStudents();

    int addNewStudent(Student student);

    void assignCourse(int studentId, int courseId);

    List<Course> getCoursesByStudent(int rollNumber);
}
