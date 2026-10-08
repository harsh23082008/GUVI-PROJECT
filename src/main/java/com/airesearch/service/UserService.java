package com.airesearch.service;

import com.airesearch.dao.UserDAO;
import com.airesearch.model.User;
import java.util.Optional;

/** Holds simple input checks and delegates persistence to the DAO. */
public class UserService {
    private final UserDAO userDAO;
    public UserService() { this(new UserDAO()); }
    public UserService(UserDAO userDAO) { this.userDAO = userDAO; }

    public Optional<User> findByEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) throw new IllegalArgumentException("Enter a valid email address.");
        return userDAO.findByEmail(email.trim());
    }
}
