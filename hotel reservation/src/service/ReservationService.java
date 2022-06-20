package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    // create all rooms data
    private final Map<String, IRoom> roomMap = new HashMap<>();
    private final Map<String, Reservation> reservationList = new HashMap<>();


    public void addRoom(IRoom room){
        roomMap.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return roomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        reservationList.put(customer.getEmail(), reservation);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        return roomMap.values();
    }

    public Collection<IRoom> getAllRooms(){
        System.out.println("Room");
        return roomMap.values();
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

        // create link to save found records
        Collection<Reservation> matchedReservation = new LinkedList<>();
        matchedReservation.add(reservationList.get(customer.getEmail()));
        return matchedReservation;
    }

    public void printAllReservation() {
        reservationList.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
