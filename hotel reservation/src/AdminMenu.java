import api.AdminResource;
import model.Room;
import model.RoomType;

import java.util.Scanner;

public class AdminMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static AdminResource adminResource = new AdminResource();

    public AdminMenu() {

        try {
            String input = "";
            do {


                System.out.println("1. See all customers.");
                System.out.println("2. See all rooms.");
                System.out.println("3. See all Reservations");
                System.out.println("4. Add a Room.");
                System.out.println("5. Back to Main Menu.");

                input = scanner.next();

                switch (input) {
                    case "1" -> adminResource.getAllCustomers();
                    case "2" -> adminResource.getAllRooms();
                    case "3" -> seeReservation();
                    case "4" -> addRoom();
                    case "5" -> MainMenu.mainMenu();
                }
            } while (input != "5");
        } catch (StringIndexOutOfBoundsException err) {
            System.out.println(err);
        }
    }

    public static void addRoom() {
        System.out.println("Room Number: ");
        String roomNumber = scanner.next();
        System.out.println("Room Price: ");
        try {
            double price = Double.parseDouble(scanner.next());
            System.out.println("Room Type: \"SINGLE\" or \"DOUBLE\" only!!!");
            String type = scanner.next();

            RoomType roomType = RoomType.valueOf(type);

            Room room = new Room(roomNumber, price, roomType);

            adminResource.addRoom(room);

        } catch (NumberFormatException err) {

            System.out.println("Please enter a number. ");

        } catch (IllegalArgumentException err) {
            System.out.println("ROOM TYPE accepts \"SINGLE\" or \"DOUBLE\" only!!!");
        }
    }

    public static void seeReservation() {
        adminResource.displayAllReservations();
    }
}
