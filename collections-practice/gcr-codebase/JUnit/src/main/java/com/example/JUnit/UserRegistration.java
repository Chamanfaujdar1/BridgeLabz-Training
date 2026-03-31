package com.example.JUnit;

public class UserRegistration {
	public boolean registerUser(String username, String email, String password) {

        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        return true; // registration successful
    }
}
