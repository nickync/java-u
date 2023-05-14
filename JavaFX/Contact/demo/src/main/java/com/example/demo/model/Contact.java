package com.example.demo.model;

public class Contact {
    private String firstName;
    private String lastName;
    private Integer number;

    public Contact(String firstName, String lastName, Integer number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return
                firstName + ' ' +
                lastName + ' ' +
                number;
    }
}
