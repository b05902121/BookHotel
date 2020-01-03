package databaseUtil.Item;

import com.google.gson.annotations.SerializedName;

/*
* In order to load the 'HotelList.json' file provided by the TAs,
* we have to create the corresponding attributes in order to match the json file.
* What's more, with specify @SerializedName, gson function can help us to parse the files.
*
* However, we don't maintain the database as these attribute types.
* For a data in HotelList.json,
* {
    "HotelID": 0,
    "HotelStar": 2,
    "Locality": "台北",
    "Street-Address": "民生東路一段28號",
    "Rooms": [
      {
        "RoomType": "Single",
        "RoomPrice": 518,
        "Number": 29
      },
      {
        "RoomType": "Double",
        "RoomPrice": 1251,
        "Number": 21
      },
      {
        "RoomType": "Quad",
        "RoomPrice": 2122,
        "Number": 13
      }
    ]
  }
*
* We only save Hotel as following:
* | HotelID | HotelStar | Locality | Street-Address     |
* | ------- | --------- | -------- | ------------------ |
* | 0       | 2         | "台北"   | "民生東路一段28號" |
*
* As for the Room,
* | RoomID  | HotelID | RoomType     | RoomPrice | DateAvailable |
* | ------- | ------- | ------------ | --------- | ------------- |
* | 0 ~ 28  | 0       | "SingleRoom" | 518       | boolean[365]  | * 29
* | 29 ~ 49 | 0       | "DoubleRoom" | 1251      | boolean[365]  | * 21
* | 50 ~ 62 | 0       | "QuadRoom"   | 2122      | boolean[365]  | * 13
*
* And so on.
 */

public class HotelForJson {
    @SerializedName("HotelID")
    private Integer hotelId;
    @SerializedName("HotelStar")
    private Integer hotelStar;
    @SerializedName("Locality")
    private String locality;
    @SerializedName("Street-Address")
    private String address;
    @SerializedName("Rooms")
    private RoomForJson[] rooms;

    public HotelForJson(Integer hotelStar, String address, String locality) {
        // hotelId is specified when INSERT;
        // this.hotelId = hotelId;
        this.hotelStar = hotelStar;
        this.address = address;
        this.locality = locality;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public Integer getHotelStar() {
        return hotelStar;
    }

    public String getLocality() {
        return locality;
    }

    public String getAddress() {
        return address;
    }

    public RoomForJson[] getRooms() {
        return rooms;
    }
}
