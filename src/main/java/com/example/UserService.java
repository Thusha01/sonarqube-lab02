package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    // ⚠️ Ideally this should come from env variable (not hardcoded)
    private String password = "admin123";

    // FIXED: No SQL Injection + auto close resources + specific exception
    public void findUser(String username) throws SQLException {

        String sql = "SELECT id, name, email, role FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeQuery();

            logger.info("User search executed successfully");
        }
    }

    // FIXED: Same improvements here
    public void deleteUser(String username) throws SQLException {

        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();

            logger.info("User deleted successfully");
        }
    }
}
