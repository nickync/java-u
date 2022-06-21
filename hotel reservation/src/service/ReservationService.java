package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {
    // create all rooms data
    private static final Map<String, IRoom> roomMap = new HashMap<>();
    private static final Map<String, Reservation> reservationList = new HashMap<>();


    public void addRoom(IRoom room){
        roomMap.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        roomMap.values().forEach(item -> {
            System.out.println(item.getRoomNumber());
        });
        return roomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){


        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        reservation.toString();

        reservationList.put(customer.getEmail(), reservation);

        System.out.println("reserved");

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,7);
        String checkInDatePrePro = sdf.format(checkInDate);
        String checkOutDatePrePro = sdf.format(checkOutDate);

        Date checkInDate7 = sdf.parse(checkInDatePrePro);
        Date checkOutDate7 = sdf.parse(checkOutDatePrePro);

        Collection<IRoom> availableRooms = new LinkedList<>();

        reservationList.values().forEach(item ->{
            if (item.getCheckInDate() == checkInDate && item.getCheckOutDate() == checkOutDate ||
                item.getCheckInDate() == checkInDate7 && item.getCheckOutDate() == checkOutDate7){
                System.out.println("Not available");

            } else {
                availableRooms.add(item.getRoom());
            }
        });
        availableRooms.forEach(item -> {
            System.out.println(item);
        });
        return availableRooms;
    }

    public Collection<IRoom> getAllRooms(){
        System.out.println(roomMap.values());
        return roomMap.values();
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

        // create link to save found records
        Collection<Reservation> matchedReservation = new LinkedList<>();
        matchedReservation.add(reservationList.get(customer.getEmail()));
        System.out.println(matchedReservation.stream().toList());
        return matchedReservation;
    }

    public void printAllReservation() {

        reservationList.forEach((key, value) -> System.out.println(key + "<-*-> " + value.toString()));
    }
}
