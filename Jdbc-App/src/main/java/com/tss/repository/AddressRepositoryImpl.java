package com.tss.repository;

import com.tss.config.DBConnection;
import com.tss.entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressRepositoryImpl implements AddressRepository {

    private Connection connection;

    public AddressRepositoryImpl() {
        connection = DBConnection.connect();
    }

    @Override
    public void addAddress(Address address) {

        String sql = "INSERT INTO address(student_id, city, state, pincode) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, address.getStudentId());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getState());
            ps.setString(4, address.getPincode());

            int rows = ps.executeUpdate();

            System.out.println(rows + " address inserted to student successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
