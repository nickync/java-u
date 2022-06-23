package model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;

    private final String email;

    public Customer(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;

        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

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

