import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
    static HotelResource hotelResource = new HotelResource();
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
                    System.out.println("Enter your check in: ");
                    String dayIn = scanner.next();
                    System.out.println("Enter your check out date: ");
                    String dayOut = scanner.next();

                    try {
                       Date checkIn = new SimpleDateFormat("MM-dd-yyyy").parse(dayIn);
                       Date checkOut = new SimpleDateFormat("MM-dd-yyyy").parse(dayOut);

                       hotelResource.findARoom(checkIn, checkOut);

                       System.out.println("Reserve a room? Y or N");

                       String ans = scanner.next();

                       if (Objects.equals(ans, "Y")){
                           System.out.println("Enter your email: ");
                           String email = scanner.next();
                           Customer customer = hotelResource.getCustomer(email);
                           System.out.println("What room would you like to reserve: ");
                           //hotelResource.getAllRooms();
                           String room = scanner.next();

                           try {
                               IRoom roomNum = hotelResource.getRoom(room);

                               hotelResource.bookARoom(email, roomNum, checkIn, checkOut);

                           } catch (NullPointerException err){
                               System.out.println("Room not found!");
                               new MainMenu();
                           }

                       }

                    } catch (ParseException err) {
                        System.out.println(err);
                    }

                } else if (input.equals("2")) {
                    System.out.println("Enter your email: ");

                    input = scanner.next();
                    try {
                      hotelResource.getCustomerReservations(input);

                    } catch (NullPointerException err) {
                        System.out.println("Email not found!!!");
                    }


                } else if (input.equals("3")) {

                    System.out.println("First name: ");
                    String firstName = scanner.next();
                    System.out.println("Last name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    hotelResource.createACustomer(firstName, lastName, email);

                } else if (input.equals("4")) {
                    new AdminMenu();
                } else if (input.equals("5")) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid input");
                }
            } while (input != "5");

        } catch (NullPointerException err){
            System.out.println("Invalid Email......Exiting");
            new MainMenu();
        }

    }
}
