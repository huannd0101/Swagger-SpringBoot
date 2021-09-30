package com.example.swagger.dto;

public class UsersDTO {
    private String username;
    private String password;

    public UsersDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UsersDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
