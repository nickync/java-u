package model;

import java.util.Date;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        super();
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }
    public Date getCheckInDate(){
        return checkInDate;
    }

    public Date getCheckOutDate(){
        return checkOutDate;
    }

    public IRoom getRoom(){
        return room;
    }


    @Override
    public String toString() {
        return customer.getName() + " * " + checkInDate +" * " + checkOutDate + " Room: " + room.getRoomNumber();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;

        if (!(o instanceof Reservation reservation)) {
            return false;
        }

        if ((o instanceof Reservation) && (((Reservation) o).getCheckInDate() == ((Reservation) o).getCheckInDate())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int hashCode = 10;
        hashCode = (32 * hashCode);
        return hashCode;
    }
}
