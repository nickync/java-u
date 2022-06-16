package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public String getRoomNumber(){
        return roomNumber;
    }

    @Override
    public RoomType getRoomType(){
        return enumeration;
    }

    @Override
    public boolean isFree(){
        return isFree();
    }

    @Override
    public String toString(){
        System.out.println(roomNumber + " " + price + " " + enumeration);
        return "";
    }
}
