import api.AdminResource;
import model.Room;
import model.RoomType;

import java.util.Scanner;

public class AdminMenu {

    public AdminMenu(){
        AdminResource adminResource = new AdminResource();

        String input = "";
        try {
            do {
                Scanner scanner = new Scanner(System.in);

                System.out.println("1. See all customers.");
                System.out.println("2. See all rooms.");
                System.out.println("3. See all Reservations");
                System.out.println("4. Add a Room.");
                System.out.println("5. Back to Main Menu.");

                input = scanner.next();

                if(input.equals("1")){
                    adminResource.getAllCustomers();
                } else if (input.equals("2")){
                    adminResource.getAllRooms();
                } else if (input.equals("3")){
                    adminResource.displayAllReservations();
                } else if (input.equals("4")){
                    System.out.println("Room Number: ");
                    String roomNumber = scanner.next();
                    System.out.println("Room Price: ");
                    double price = Double.parseDouble(scanner.next());
                    System.out.println("Room Type: ");
                    String type = scanner.next();

                    RoomType roomType = RoomType.valueOf(type);

                    Room room = new Room(roomNumber, price,roomType);

                    adminResource.addRoom(room);

                } else if (input.equals("5")){
                    MainMenu.mainMenu();
                }
            } while (input != "5");
        } catch (StringIndexOutOfBoundsException err){
            System.out.println(err);
        }
    }
}
