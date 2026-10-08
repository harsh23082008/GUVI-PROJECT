package com.airesearch.util;

import com.airesearch.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Opens short-lived JDBC connections using local environment configuration. */
public final class DatabaseConnection {
    private static final String URL = setting("airesearch.db.url", "AIRESEARCH_DB_URL", "jdbc:mysql://localhost:3306/ai_research_platform?serverTimezone=UTC");
    private static final String USER = setting("airesearch.db.user", "AIRESEARCH_DB_USER", "root");
    private static final String PASSWORD = setting("airesearch.db.password", "AIRESEARCH_DB_PASSWORD", "");
    private DatabaseConnection() { }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseException("Could not connect to MySQL. Check the local database settings.", e);
        }
    }

    private static String setting(String property, String environment, String fallback) {
        String value = System.getProperty(property);
        if (value == null || value.isBlank()) value = System.getenv(environment);
        return value == null ? fallback : value;
    }
}
