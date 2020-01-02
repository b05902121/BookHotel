package main;

public class Hotel {
    private Integer hotelId;
    private Integer hotelStar;
    private String locality;
    private String address;
    private Integer singleRoomPrice;
    private Integer doubleRoomPrice;
    private Integer quadRoomPrice;
    
    public Hotel(Integer hotelId, Integer hotelStar, String address, String locality, Integer sPrice, Integer dPrice, Integer qPrice) {
        this.hotelId = hotelId;
        this.hotelStar = hotelStar;
        this.address = address;
        this.locality = locality;
        this.singleRoomPrice = sPrice;
        this.doubleRoomPrice = dPrice;
        this.quadRoomPrice = qPrice;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public Integer getHotelStar() {
        return hotelStar;
    }
    
    public Integer getSingleRoomPrice() {
    	return singleRoomPrice;
    }
    
    public Integer getDoubleRoomPrice() {
    	return doubleRoomPrice;
    }
    
    public Integer getQuadRoomPrice() {
    	return quadRoomPrice;
    }

    public String getLocality() {
        return locality;
    }
    
    public String getAddress() {
        return address;
    }
    
}
