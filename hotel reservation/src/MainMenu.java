import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;

public class MainMenu {
    static ReservationService reservationService = new ReservationService();
    static CustomerService customerService = new CustomerService();
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        String input = "";

        try {
            do {
                Scanner scanner = new Scanner(System.in);

                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservation");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");


                input = scanner.next();
                if (input.equals("1")) {
                    System.out.println("1");
                } else if (input.equals("2")) {
                    reservationService.printAllReservation();
                } else if (input.equals("3")) {
                    System.out.println("First name: ");
                    String firstName = scanner.next();
                    System.out.println("Last name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    customerService.addCustomer(firstName, lastName, email);
                    customerService.getAllCustomers();
                } else if (input.equals("4")) {
                    new AdminMenu();
                } else if (input.equals("5")) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid input");
                }
            } while (input != "5");

        } catch (IllegalArgumentException err){
            System.out.println("Invalid Email......Exiting");
            new MainMenu();
        }

    }
}
