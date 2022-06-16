package model;

public class FreeRoom extends Room{
    private Double price = 0.0;

    public FreeRoom(String RoomNumber, Double price, RoomType enumeration){
        super(RoomNumber, price, enumeration);
        this.price = 0.0;
    }

    public String toString() {
        System.out.println("Room" );
        return "";
    }
}
