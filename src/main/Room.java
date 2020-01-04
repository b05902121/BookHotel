package main;

public class Room {
    private String roomType;
    private Integer roomPrice;
    private boolean[] DateIsAvailable = new boolean[365];
    
    public Room(String roomType, Integer roomPrice) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }
}
