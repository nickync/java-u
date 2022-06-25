package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    // create hashmap for all customers
    private static final Map<String, Customer> customers = new HashMap<String, Customer>();

    private static final CustomerService customerService = new CustomerService();

    private CustomerService(){}

    public static CustomerService singleton(){
        return customerService;
    }

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
