package databaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHotel extends DatabaseConnect{
    public DatabaseHotel(String configFile) {
        super(configFile);
    }

    public Integer insertHotel(String hotelName, Integer singleRoomNum, Integer DoubleRoomNum, Integer quadRoomNum, String note){
        /* Return the new HotelID which is created when inserts this data. */
        System.out.print("[LOG] DatabaseHotel insertHotel().\n");
        Integer totalHotelNumber = this.getTotalHotelNumber();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `Hotels`(`HotelName`,`HotelID`,`SingleRoomNum`,`DoubleRoomNum`,`QuadRoomNum`,`Note`) VALUES ('");
        stringBuilder.append(hotelName);
        stringBuilder.append("','");
        stringBuilder.append(totalHotelNumber);
        stringBuilder.append("','");
        stringBuilder.append(singleRoomNum);
        stringBuilder.append("','");
        stringBuilder.append(DoubleRoomNum);
        stringBuilder.append("','");
        stringBuilder.append(quadRoomNum);
        stringBuilder.append("','");
        stringBuilder.append(note);
        stringBuilder.append("');");
        System.out.print(stringBuilder.toString() + "\n");
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber;
    }

    public ResultSet getAllHotels(){
        System.out.print("[LOG] DatabaseHotel getAllHotels().\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `Hotels`;");
        try {
            return stmt.executeQuery(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getHotelsByHotelName(String hotelName){
        System.out.print("[LOG] DatabaseHotel getHotelsByHotelName().\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `Hotels` WHERE  `HotelName` = '");
        stringBuilder.append(hotelName);
        stringBuilder.append("' ;");
        try {
            return stmt.executeQuery(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getHotelsByAvailableRoomTypeNum(String RoomType){
        /* RoomType = {SingleRoom,DoubleRoom,QuadRoom} */
        /* ex. SELECT * FROM `Hotels` WHERE  `SingleRoomNum` > 0 ; */
        System.out.print("[LOG] DatabaseHotel getHotelsByAvailableRoomTypeNum().\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `Hotels` WHERE  `");
        stringBuilder.append(RoomType);
        stringBuilder.append("Num` > 0 ;");
        try {
            return stmt.executeQuery(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getTotalHotelNumber(){
        Integer totalHoteNumber = 0;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM `Hotels`;");
            while (resultSet.next()) {
                Integer getHotelID = Integer.parseInt(resultSet.getString("HotelID"));
                if(getHotelID > totalHoteNumber){
                    totalHoteNumber = getHotelID;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHoteNumber + 1;
    }
}
