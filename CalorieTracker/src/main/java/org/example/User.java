package org.example;

public class User {

    private String username; // PMD: Unused field
    private String password; // PMD: Unused field

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
