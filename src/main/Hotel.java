package main;

import java.util.ArrayList;

public class Hotel {
    private Integer hotelId;
    private Integer hotelStar;
    private String locality;
    private String address;
    private ArrayList<Room> singleRoom;
    private ArrayList<Room> doubleRoom;
    private ArrayList<Room> quadRoom;
    
    public Hotel(Integer hotelId, Integer hotelStar, String address, String locality, Integer snum, Integer dnum, Integer qnum) {
        this.hotelId = hotelId;
        this.hotelStar = hotelStar;
        this.address = address;
        this.locality = locality;
        this.singleRoom = new ArrayList<Room>(snum);
        this.doubleRoom = new ArrayList<Room>(dnum);
        this.quadRoom = new ArrayList<Room>(qnum);
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public Integer getHotelStar() {
        return hotelStar;
    }
    
    public Integer getSingleRoomPrice() {
    	return singleRoom.get(0).getRoomPrice();
    }
    
    public Integer getDoubleRoomPrice() {
    	return doubleRoom.get(0).getRoomPrice();
    }
    
    public Integer getQuadRoomPrice() {
    	return quadRoom.get(0).getRoomPrice();
    }
    
    public int getSingleRoomNum() {
    	return singleRoom.size();
    }
    
    public int getDoubleRoomNum() {
    	return doubleRoom.size();
    }
    
    public int getQuadRoomNum() {
    	return quadRoom.size();
    }
}
