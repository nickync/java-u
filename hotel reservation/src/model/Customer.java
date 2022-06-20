package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;

    private String email;
    private String emailRegex = "^(.+)@(.+).(.+)$";

    private Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid Email");
        }
        this.email = email;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " Email: " + email;
    }
}

