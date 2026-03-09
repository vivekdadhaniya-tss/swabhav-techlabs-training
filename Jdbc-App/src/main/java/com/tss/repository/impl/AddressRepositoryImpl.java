package com.tss.repository.impl;

import com.tss.config.DBConnection;
import com.tss.entity.Address;
import com.tss.repository.AddressRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressRepositoryImpl implements AddressRepository {

    private Connection connection;

    public AddressRepositoryImpl() {
        this.connection = DBConnection.connect();
    }

    @Override
    public void addAddress(Address address) {

        String sql = "INSERT INTO address(student_id, city, state, pincode) VALUES (?, ?, ?, ?)";

        // Use try-with-resources to ensure resources are closed
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, address.getStudentId());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getState());
            ps.setString(4, address.getPincode());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Address inserted successfully");
            }

        } catch (SQLException e) {
            if ("23503".equals(e.getSQLState())) {
                System.err.println("Error: Invalid Student ID provided for address.");
            } else {
                System.err.println("Database error while adding address: " + e.getMessage());
            }
        }
    }
}
