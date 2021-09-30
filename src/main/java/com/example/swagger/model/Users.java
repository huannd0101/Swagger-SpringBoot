package com.example.swagger.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated user id")
    private Long id;

    @Column(name = "username", nullable = false)private String username;

    @Column(name = "password", nullable = false)private String password;

    public Users() {
    }

    public Users(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
