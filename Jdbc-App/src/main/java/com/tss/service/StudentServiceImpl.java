package com.tss.service;

import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.repository.StudentRepository;
import com.tss.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

//    public void setStudentRepository(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public int addNewStudent(Student student) {
        return studentRepository.addNewStudent(student);
    }

    @Override
    public void assignCourse(int studentId, int courseId) {
        studentRepository.assignCourse(studentId, courseId);
    }

    @Override
    public List<Course> getCoursesByStudent(int studentId) {
        return studentRepository.getCoursesByStudent(studentId);
    }
}
