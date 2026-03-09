package com.tss.repository;

import com.tss.config.DBConnection;
import com.tss.entity.Course;
import com.tss.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    private final Connection connection;

    public StudentRepositoryImpl() {
        connection = DBConnection.connect();
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                int rollNumber = resultSet.getInt("roll_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student(studentId, rollNumber, age, name);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    @Override
    public int addNewStudent(Student student) {

        String sql = "INSERT INTO student (roll_number, name, age) VALUES (?, ?, ?) RETURNING student_id";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            int rollNumber = student.getRollNumber();
            String name = student.getName();
            int age = student.getAge();

            ps.setInt(1, rollNumber);
            ps.setString(2, name);
            ps.setInt(3, age);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("student_id");
            }

            int rows = ps.executeUpdate();
            System.out.println(rows + "student inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public void assignCourse(int studentId, int courseId) {
        String sql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            int rows = ps.executeUpdate();
            System.out.println(rows + "course assign to student successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Course> getCoursesByStudent(int rollNumber) {

        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM course c " +
                "JOIN enrollment e ON c.course_id = e.course_id " +
                "JOIN student s ON e.student_id = s.student_id " +
                "WHERE s.roll_number = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, rollNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                double courseFees = rs.getDouble("fees");

                courses.add(new Course(courseId, courseName, courseFees));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }
}
