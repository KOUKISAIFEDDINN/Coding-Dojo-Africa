package com.auth.loginandregistration.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

    @NotEmpty(message="email is required!")
    @Email(message="Please Enter a Valid Email")
    private String email;

    @NotEmpty(message="Password is required!")
    @Size(min = 8 , max=120, message="Password must be between 8 and 128 characters")
    private String password;

    public LoginUser(){

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
}
