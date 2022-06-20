package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {

    ReservationService reservationService = new ReservationService();
    CustomerService customerService = new CustomerService();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(IRoom room) {
        reservationService.addRoom(room);
    }

    public void getAllRooms() {
        Collection<IRoom> allRooms = reservationService.getAllRooms();
        System.out.println(allRooms);
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        reservationService.printAllReservation();
    }
}
