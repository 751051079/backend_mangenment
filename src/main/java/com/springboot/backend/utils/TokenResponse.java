package com.springboot.backend.utils;

public class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    // Getter and setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
