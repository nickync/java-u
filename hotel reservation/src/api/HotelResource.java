package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String firstName, String lastName, String email) {

        customerService.addCustomer(firstName, lastName, email);

    }

    public IRoom getRoom(String roomNumber) {

        return reservationService.getARoom(roomNumber);
    }

    public void bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservationService.getCustomersReservation(customerService.getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {

        Collection<IRoom> availableRooms = reservationService.findRooms(checkIn, checkOut);
        Collection<IRoom> availableRooms7 = reservationService.findRooms7(checkIn, checkOut);

        for (IRoom room : availableRooms){
            System.out.println("Available room: " + room.getRoomNumber() + " Price: " + room.getRoomPrice() + " Room Type: " + room.getRoomType());
        }

        for (IRoom room : availableRooms7){
            System.out.println("Alternative date room: " + room.getRoomNumber() + " Price: " + room.getRoomPrice() + " Room Type: " + room.getRoomType());
        }
        return null;
    }

    public void getAllRooms(){
        reservationService.getAllRooms();
    }
}
