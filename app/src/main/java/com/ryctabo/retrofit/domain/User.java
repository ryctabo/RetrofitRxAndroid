package com.ryctabo.retrofit.domain;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0
 */
public class User {

    private Long id;

    private String name;

    private String username;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
