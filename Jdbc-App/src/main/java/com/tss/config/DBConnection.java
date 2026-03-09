package com.tss.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {}

    public static Connection connect() {

        try {

            if(connection == null || connection.isClosed()) {
                Properties props = new Properties();

                // Use try-with-resources to ensure InputStream is closed
                try (InputStream input = DBConnection.class
                        .getClassLoader()
                        .getResourceAsStream("db.properties")) {

                    if (input == null) {
                        throw new RuntimeException("Sorry, unable to find db.properties");
                    }
                    props.load(input);
                }

                String driver = props.getProperty("db.driver");
                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                Class.forName(driver);

                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established successfully");
            }
            return connection;

        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}