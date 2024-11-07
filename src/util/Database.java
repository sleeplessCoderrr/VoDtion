package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";   // Replace with your database username
    private static final String PASSWORD = "password"; // Replace with your database password

    // Method to get the connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

