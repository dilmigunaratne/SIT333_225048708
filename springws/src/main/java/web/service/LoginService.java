package web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    // Mock user database
    private static Map<String, User> users = new HashMap<>();

    static {
        // Adding a sample user
        users.put("dilmi", new User("dilmi", "dilmi123", "2002-01-01"));
    }

    /**
     * Static method returns true for successful login, false otherwise.
     * @param username
     * @param password
     * @param dob
     * @return boolean
     */
    public static boolean login(String username, String password, String dob) {
        User user = users.get(username);

        if (user != null && user.getPassword().equals(password) && user.getDob().equals(dob)) {
            return true;
        }
        return false;
    }

    /**
     * Class representing a user.
     */
    static class User {
        private String username;
        private String password;
        private String dob;

        public User(String username, String password, String dob) {
            this.username = username;
            this.password = password;
            this.dob = dob;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getDob() {
            return dob;
        }
    }
}
