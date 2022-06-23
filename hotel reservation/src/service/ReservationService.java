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

    private static final Collection<IRoom> availableRooms = new LinkedList<>(roomMap.values());


    private static final Collection<IRoom> availableRooms7 = new LinkedList<>();



    public void addRoom(final IRoom room){
        roomMap.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return roomMap.get(roomId);
    }

    public void reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            String checkInDatePrePro = sdf.format(checkInDate);
            String checkOutDatePrePro = sdf.format(checkOutDate);

            Date checkInDate7 = sdf.parse(checkInDatePrePro);
            Date checkOutDate7 = sdf.parse(checkOutDatePrePro);

            if(roomMap.isEmpty()) {
                System.out.println("No rooms were added to the System!");
            } else if (reservationList.isEmpty()) {
                Reservation currentReservation = new Reservation(customer, room, checkInDate, checkOutDate);
                reservationList.put(customer.getEmail(), currentReservation);
                System.out.println("Room" + currentReservation.getRoom() + " is reserved!");
            } else {
                    for (Reservation reservation : reservationList.values()) {
                        if ((Objects.equals(reservation.getRoom().getRoomNumber(), room.getRoomNumber()) &&
                                reservation.getCheckInDate() == checkInDate &&
                                reservation.getCheckOutDate() == checkOutDate)) {
                            System.out.println("Checking other days......");
                            if (Objects.equals(reservation.getRoom().getRoomNumber(), room.getRoomNumber()) &&
                                    reservation.getCheckInDate() == checkInDate7 &&
                                    reservation.getCheckOutDate() == checkOutDate7){
                                System.out.println("No rooms available....!");
                            } else {
                                Reservation currentReservation = new Reservation(customer, room, checkInDate7, checkOutDate7);
                                reservationList.put(customer.getEmail(), currentReservation);
                                System.out.println("Room" + currentReservation.getRoom() + " is reserved!");
                            }
                        } else if (roomMap.containsValue(room)) {
                            Reservation currentReservation = new Reservation(customer, room, checkInDate, checkOutDate);
                            reservationList.put(customer.getEmail(), currentReservation);
                            System.out.println("Room reserved");
                            return;
                        } else {
                            System.out.println("Room not found in the hotel!");
                            return;
                        }
                    }
                }
        } catch (ParseException err) {
            System.out.println("Invalid Date format!");
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        try {

                reservationList.values().forEach(item -> {
                    System.out.println(item.getCheckInDate());
                    System.out.println(checkInDate);
                    if (!(item.getCheckInDate() == checkInDate && item.getCheckOutDate() == checkOutDate)) {
                        availableRooms.removeIf(e -> e == item.getRoom());
                        System.out.println("Checking alternative dates...");
                    } else {
                        availableRooms.add(item.getRoom());
                    }
                });
            return availableRooms;
        }catch (NullPointerException err){
            System.out.println(err);
        }
        return null;
    }

    public Collection<IRoom> findRooms7(Date checkInDate, Date checkOutDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            String checkInDatePrePro = sdf.format(checkInDate);
            String checkOutDatePrePro = sdf.format(checkOutDate);

            Date checkInDate7 = sdf.parse(checkInDatePrePro);
            Date checkOutDate7 = sdf.parse(checkOutDatePrePro);


            reservationList.values().forEach(item -> {
                if (item.getCheckInDate() == checkInDate7 && item.getCheckOutDate() == checkOutDate7) {
                    System.out.println("No rooms available on alternative dates!");
                } else {
                    availableRooms7.add(item.getRoom());
                }
            });

            return availableRooms7;

        } catch (ParseException err){
            System.out.println("Invalid date!");
        }
        return null;
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
