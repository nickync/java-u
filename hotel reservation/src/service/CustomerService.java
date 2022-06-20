package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private String email;
    private String firstName;
    private String lastName;
    // create hashmap for all customers
    Map<String, Customer> customers = new HashMap<String, Customer>();

    public void addCustomer(String firstName, String lastName, String email) {

        // add customers to map
        customers.put(email, new Customer(firstName, lastName, email));

    }

    // find customer with email
    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        for(Map.Entry<String, Customer> entry: customers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        };
        return customers.values();
    }

}
