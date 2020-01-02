package databaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import main.Hotel;

public class DatabaseHotel extends DatabaseConnect{
    private StringBuilder stringBuilder = new StringBuilder();
    private PreparedStatement prstmtHotel = null;
    private PreparedStatement prstmtRoom = null;

    public DatabaseHotel(String configFile) throws SQLException {
        super(configFile);
    }

    public Integer insertHotel(Integer hotelStar, String locality, String address, Integer sNum, Integer dNum, Integer qNum, Integer sPrice, Integer dPrice, Integer qPrice){
        /* Return the new HotelID which is created when inserts this data. */
        System.out.print("[dbUil] DatabaseHotel insertHotel().\n");
        Integer totalHotelNumber = this.getTotalHotelNumber();
        try {
            prstmtHotel = conn.prepareStatement("INSERT INTO `Hotels`(`HotelID`,`HotelStar`,`Locality`,`Street-Address`,`SNum`,`DNum`,`QNum`,`SPrice`,`DPrice`,`QPrice`) VALUES (?,?,?,?,?,?,?,?,?,?);");
            prstmtHotel.setInt(1, totalHotelNumber);
            prstmtHotel.setInt(2, hotelStar);
            prstmtHotel.setString(3, locality);
            prstmtHotel.setString(4, address);
            prstmtHotel.setInt(5, sNum);
            prstmtHotel.setInt(6, dNum);
            prstmtHotel.setInt(7, qNum);
            prstmtHotel.setInt(8, sPrice);
            prstmtHotel.setInt(9, dPrice);
            prstmtHotel.setInt(10, qPrice);
            int numUpd = prstmtHotel.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber;
    }

    public ArrayList<Hotel> getHotelsByInformation(Integer hotelStar, Integer dateStart, Integer dateEnd, Integer sNumQuery, Integer dNumQuery, Integer qNumQuery){
        /* SELECT * FROM `Hotels` WHERE `HotelStar`=hotelStar ORDER BY sNumQuery*SPrice+dNumQuery*DPrice+qNumQuery*QPrice DESC; */
        System.out.print("[dbUtil] DatabaseHotel getHotelsByInformation().\n");
        ResultSet resultSetHotel = null;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        byte dateIsAvailableBytes[] = new byte[365];
        Arrays.fill(dateIsAvailableBytes,(byte)0);
        for (int i = dateStart; i <= dateEnd ; i++){
            dateIsAvailableBytes[i] = (byte)1;
        }
//        System.out.print("[dbUtil] getHotelsByInformation dateIsAvailableBytes " + new String(dateIsAvailableBytes, Charset.forName("UTF-8")) + "\n");
        try {
            prstmtHotel = conn.prepareStatement("SELECT * FROM `Hotels` WHERE `HotelStar`=? AND `HotelId`=any(SELECT HotelId FROM `Rooms` WHERE (`DateIsAvailable`&?)=?) ORDER BY ?*SPrice+?*DPrice+?*QPrice DESC;");
            prstmtHotel.setInt(1, hotelStar);
            prstmtHotel.setBytes(2, dateIsAvailableBytes);
            prstmtHotel.setBytes(3, dateIsAvailableBytes);
            prstmtHotel.setInt(4, sNumQuery);
            prstmtHotel.setInt(5, dNumQuery);
            prstmtHotel.setInt(6, qNumQuery);
            resultSetHotel = prstmtHotel.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSetHotel != null) {
            try {
                while (resultSetHotel.next()){
                    hotels.add(new Hotel(
                                        Integer.parseInt(resultSetHotel.getString("HotelId")),
                                        Integer.parseInt(resultSetHotel.getString("HotelStar")),
                                        resultSetHotel.getString("Street-Address"),
                                        resultSetHotel.getString("Locality"),
                                        Integer.parseInt(resultSetHotel.getString("SPrice")),
                                        Integer.parseInt(resultSetHotel.getString("DPrice")),
                                        Integer.parseInt(resultSetHotel.getString("QPrice"))
                                        )
                                );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hotels;
    }

    public Integer getTotalHotelNumber(){
        Integer totalHotelNumber = 0;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM `Hotels`;");
            while (resultSet.next()) {
                Integer getHotelID = Integer.parseInt(resultSet.getString("HotelID"));
                if(getHotelID > totalHotelNumber){
                    totalHotelNumber = getHotelID;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber + 1;
    }

}
