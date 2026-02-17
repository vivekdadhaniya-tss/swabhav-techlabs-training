package com.tss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;
    private StudentService studentService;

    @BeforeEach
    void setup() {
        studentService = Mockito.mock(StudentService.class);
        student = new Student(studentService);
    }

    @Test
    void calculatePercentage() {
        Mockito.when(studentService.getTotalMarks()).thenReturn(700.0);
        Mockito.when(studentService.getTotalStudents()).thenReturn(7);

        assertEquals(100.0, student.calculatePercentage());
    }
}