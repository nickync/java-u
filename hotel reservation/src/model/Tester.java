package model;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "j@email.com");

        System.out.println(customer);

        Customer customer1 = new Customer("first", "second", "email");
        System.out.println(customer1);

    }
}
