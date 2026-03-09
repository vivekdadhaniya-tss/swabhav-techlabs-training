package com.tss.repository.impl;

import com.tss.config.DBConnection;
import com.tss.entity.Course;
import com.tss.entity.Student;
import com.tss.repository.CourseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    @Override
    public void addNewCourse(Course course) {
        String sql = "INSERT INTO course(course_name, fees) VALUES (?, ?)";

        try (Connection connection = DBConnection.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.setDouble(2, course.getFees());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Course inserted successfully");
            }

        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.err.println("Error: A course with this name already exists.");
            } else {
                System.err.println("Database error while adding course: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";

        try (Connection connection = DBConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getDouble("fees")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database error while fetching courses: " + e.getMessage());
        }

        return courses;
    }

    public List<Student> getStudentsByCourse(int courseId) {

        List<Student> students = new ArrayList<>();
        String sql = """
                    SELECT *
                    FROM student s
                    JOIN enrollment e ON s.student_id = e.student_id
                    JOIN course c ON c.course_id = e.course_id
                    WHERE c.course_id = ?
                    """;

        try (Connection connection = DBConnection.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(
                            rs.getInt("student_id"),
                            rs.getInt("roll_number"),
                            rs.getInt("age"),
                            rs.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error while fetching students by course: " + e.getMessage());
        }

        return students;
    }
}