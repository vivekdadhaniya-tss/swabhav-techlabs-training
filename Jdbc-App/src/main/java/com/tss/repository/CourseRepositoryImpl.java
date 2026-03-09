package com.tss.repository;

import com.tss.config.DBConnection;
import com.tss.entity.Course;
import com.tss.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private Connection connection;

    public CourseRepositoryImpl() {
        connection = DBConnection.connect();
    }

    @Override
    public void addNewCourse(Course course) {

        String sql = "INSERT INTO course(course_name, fees) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, course.getCourseName());
            ps.setDouble(2, course.getFees());

            int rows = ps.executeUpdate();
            System.out.println(rows + " Course inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM course");

            while (rs.next()) {

                int id = rs.getInt("course_id");
                String name = rs.getString("course_name");
                double fees = rs.getDouble("fees");

                courses.add(new Course(id, name, fees));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int rollNUmber = rs.getInt("roll_number");
                String studentName = rs.getString("name");
                int studentAge = rs.getInt("age");

                students.add(new Student(studentId, rollNUmber, studentAge, studentName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}