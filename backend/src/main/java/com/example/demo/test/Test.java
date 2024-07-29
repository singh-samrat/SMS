package com.example.demo.test;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public Test(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Test{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
