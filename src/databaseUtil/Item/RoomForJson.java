package databaseUtil.Item;

import com.google.gson.annotations.SerializedName;

/*
* | RoomID  | HotelID | RoomType     | RoomPrice | DateAvailable |
* | ------- | ------- | ------------ | --------- | ------------- |
* | 0 ~ 28  | 0       | "SingleRoom" | 518       | boolean[365]  | * 29
* | 29 ~ 49 | 0       | "DoubleRoom" | 1251      | boolean[365]  | * 21
* | 50 ~ 62 | 0       | "QuadRoom"   | 2122      | boolean[365]  | * 13
*/

public class RoomForJson {
    @SerializedName("RoomType")
    private String roomType;
    @SerializedName("RoomPrice")
    private Integer roomPrice;
    @SerializedName("Number")
    private Integer number;

    public RoomForJson(String roomType, Integer roomPrice, Integer number) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public Integer getNumber() {
        return number;
    }

}
