import api.HotelResource;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
    static HotelResource hotelResource = new HotelResource();
    static Scanner scanner = new Scanner(System.in);
    static String input;
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){

        try {
            do {

                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservation");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");


                input = scanner.next();
                switch (input) {
                    case "1" -> findAndReserve();
                    case "2" -> seeMyReservation();
                    case "3" -> createAnAccount();
                    case "4" -> new AdminMenu();
                    case "5" -> System.exit(0);
                    default -> System.out.println("Invalid input");
                }
            } while (!Objects.equals(input, "5"));

        } catch (NullPointerException err){
            System.out.println("Null value");
            new MainMenu();
        }

    }

    public static void findAndReserve(){

        System.out.println("Enter your check in: MM/dd/yyyy");
        String dayIn = scanner.next();
        System.out.println("Enter your check out date: ");
        String dayOut = scanner.next();
        try {
            Date checkIn = new SimpleDateFormat("MM/dd/yyyy").parse(dayIn);
            Date checkOut = new SimpleDateFormat("MM/dd/yyyy").parse(dayOut);

            hotelResource.findARoom(checkIn, checkOut);

            System.out.println("Reserve a room? Y or N");

            String ans = scanner.next();

            if (Objects.equals(ans, "Y") || Objects.equals(ans, "y")) {
                System.out.println("Enter your email: ");
                String email = scanner.next();
                if(hotelResource.getCustomer(email) == null){
                    System.out.println("Please create an account: ");
                    createAnAccount();
                };
                System.out.println("What room would you like to reserve: ");
                //hotelResource.getAllRooms();
                String room = scanner.next();

                try {
                    IRoom roomNum = hotelResource.getRoom(room);
                    hotelResource.bookARoom(email, roomNum, checkIn, checkOut);
                } catch (NullPointerException err) {
                    System.out.println("Room not found!");
                    new MainMenu();
                }

            }

        } catch (ParseException err) {
            System.out.println(err);
        }
    }

    public static void seeMyReservation(){

        System.out.println("Enter your email: ");

        input = scanner.next();

        try {
            hotelResource.getCustomerReservations(input);

        } catch (NullPointerException err) {
            System.out.println("Reservation not found!!!");
        }
    }

    public static void createAnAccount(){
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        try{
            hotelResource.createACustomer(firstName, lastName, email);
        } catch (IllegalArgumentException err){
            System.out.println("Invalid Email!");
        }
    }
}
