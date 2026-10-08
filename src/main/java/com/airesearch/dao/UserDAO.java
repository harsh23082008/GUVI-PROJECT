package com.airesearch.dao;

import com.airesearch.exception.DatabaseException;
import com.airesearch.model.User;
import com.airesearch.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/** Demonstrates parameterized JDBC access for the user table. */
public class UserDAO {
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT id, name, email, role FROM users WHERE email = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) return Optional.of(new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("role")));
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DatabaseException("Could not look up the user.", e);
        }
    }
}
