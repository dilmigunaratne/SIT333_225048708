package web.service;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

	//getting the users in a list
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("dilmi", new User("dilmi", "dilmi123", "2002-08-26"));
        users.put("alice", new User("alice", "alice123", "1999-05-10"));
    }

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) return false;

        User user = users.get(username);
        if (user == null) return false;

        return user.getPassword().equals(password) && user.getDob().equals(dob);
    }

    static class User {
        private String username;
        private String password;
        private String dob;

        public User(String username, String password, String dob) {
            this.username = username;
            this.password = password;
            this.dob = dob;
        }

        public String getPassword() {
            return password;
        }

        public String getDob() {
            return dob;
        }
    }
}

