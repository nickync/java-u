package com.example.springboot.webapp.Service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password){

        boolean isValid = username.equalsIgnoreCase("a");
        boolean isValidPassword = password.equalsIgnoreCase("1");

        return isValid && isValidPassword;
    }
}
