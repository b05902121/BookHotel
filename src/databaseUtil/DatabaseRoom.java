package databaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRoom extends DatabaseConnect{
    private StringBuilder stringBuilder = new StringBuilder();

    public DatabaseRoom(String configFile) {
        super(configFile);
    }

    public Integer insertRoom(Integer roomId, Integer hotelId, String roomType, Integer roomPrice, byte[] dateIsAvailable){
        /* Return the new RoomId which is created when inserts this data. */
        System.out.print("[LOG] DatabaseHotel insertHotel().\n");
        Integer totalHotelNumber = this.getTotalRoomNumber();
        stringBuilder.setLength(0);
        stringBuilder.append("INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`,`DateIsAvailable`) VALUES ('")
                    .append(roomId).append("','")
                    .append(hotelId).append("','")
                    .append(roomType).append("','")
                    .append(roomPrice).append("','")
                    .append(dateIsAvailable).append("');\n");
        System.out.print(stringBuilder.toString() + "\n");
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber;
    }

    public Integer getTotalRoomNumber(){
        Integer totalRoomNumber = 0;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM `Hotels`;");
            while (resultSet.next()) {
                Integer getHotelID = Integer.parseInt(resultSet.getString("HotelID"));
                if(getHotelID > totalRoomNumber){
                    totalRoomNumber = getHotelID;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRoomNumber + 1;
    }
}
