package com.tss.repository.impl;

import com.tss.config.DBConnection;
import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryImpl() {
        connection = DBConnection.connect();
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getInt("roll_number"),
                        resultSet.getInt("age"),
                        resultSet.getString("name")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database error while fetching students: " + e.getMessage());
        }

        return students;
    }

    @Override
    public int addNewStudent(Student student) {
        String sql = "INSERT INTO student (roll_number, name, age) VALUES (?, ?, ?) RETURNING student_id";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, student.getRollNumber());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    int id = rs.getInt("student_id");
                    System.out.println("Student inserted successfully with ID: " + id);
                    return id;
                }
            }

        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.err.println("Error: A student with roll number " + student.getRollNumber() + " already exists.");
            } else {
                System.err.println("Database error while adding student: " + e.getMessage());
            }
        }
        return -1;
    }

    public void assignCourse(int studentId, int courseId) {
        String sql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Course assigned to student successfully");
            }

        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.err.println("Error: Student is already enrolled in this course.");
            }
            else if ("23503".equals(e.getSQLState())) {
                System.err.println("Error: Invalid Student ID or Course ID.");
            } else {
                System.err.println("Database error while assigning course: " + e.getMessage());
            }
        }
    }

    public List<Course> getCoursesByStudent(int rollNumber) {

        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM course c " +
                "JOIN enrollment e ON c.course_id = e.course_id " +
                "JOIN student s ON e.student_id = s.student_id " +
                "WHERE s.roll_number = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, rollNumber);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    courses.add(new Course(
                            rs.getInt("course_id"),
                            rs.getString("course_name"),
                            rs.getDouble("fees")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error while fetching courses by student: " + e.getMessage());
        }

        return courses;
    }
}
