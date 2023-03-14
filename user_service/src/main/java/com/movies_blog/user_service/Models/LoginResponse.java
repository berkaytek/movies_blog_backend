package com.movies_blog.user_service.Models;

public class LoginResponse {
    private String email;
    private String accessToken;

    public LoginResponse() {
    }

    public LoginResponse(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
