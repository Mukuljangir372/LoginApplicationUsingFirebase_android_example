package com.mukuljangir.application.loginapplicationusingfirebase;

public class User {
    private String email;
    private String password;
    private String name;
    public User() {
    }

    public User(String name,String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
