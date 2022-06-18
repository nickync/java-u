package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {
    private String email;
    private String firstName;
    private String lastName;

    public void addCustomer(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Customer getCustomer(String customerEmail) {
        return null;
    }

    public Collection<Customer> getAllCustomers() {

    }


}
