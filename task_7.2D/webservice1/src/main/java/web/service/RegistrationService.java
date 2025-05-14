package web.service;

import java.util.HashMap;
import java.util.Map;

public class RegistrationService {

    // Store registered users
    private static Map<String, User> users = new HashMap<>();

    // Register a new user
    public static boolean register(String firstName, String lastName, String email, String dob) {
        // Validate inputs
        if (firstName == null || firstName.isEmpty() ||
            lastName == null || lastName.isEmpty() ||
            email == null || email.isEmpty() ||
            dob == null || dob.isEmpty()) {
            return false;
        }

        if (users.containsKey(email)) {
            return false; // Email already registered
        }

        users.put(email, new User(firstName, lastName, email, dob));
        return true;
    }

    // Clear all users (for testing)
    public static void clearUsers() {
        users.clear();
    }

    // Get user count (for testing)
    public static int getUserCount() {
        return users.size();
    }

    // User class to store user details
    static class User {
        private String firstName;
        private String lastName;
        private String email;
        private String dob;

        public User(String firstName, String lastName, String email, String dob) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.dob = dob;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public String getDob() { return dob; }
    }
}
