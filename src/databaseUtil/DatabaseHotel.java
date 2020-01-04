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

    public ArrayList<Hotel> getHotelsByInformation(Integer hotelStar, Integer startDate, Integer endDate, Integer sNumQuery, Integer dNumQuery, Integer qNumQuery){
        /* SELECT * FROM `Hotels` WHERE `HotelStar`=hotelStar ORDER BY sNumQuery*SPrice+dNumQuery*DPrice+qNumQuery*QPrice DESC; */
        System.out.print("[dbUtil] DatabaseHotel getHotelsByInformation().\n");
        ResultSet resultSetHotel = null;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        byte dateIsAvailableBytes[] = new byte[365];
        Arrays.fill(dateIsAvailableBytes,(byte)0);
        dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, startDate, endDate);
        try {
        	prstmtHotel = conn.prepareStatement(
        			"SELECT *" + 
					"FROM `Hotels`" +
					"WHERE `HotelID` in (SELECT DISTINCT `hotels_subtable`.`HotelId` " + 
										"FROM ( SELECT `HotelId`,`RoomType`,count(*) as c1 " + 
												"FROM `Rooms` " + 
												"WHERE (`DateIsAvailable`&?)=? " +
												"group by `HotelId`,`RoomType` " +
											" ) as rooms_subtable " +
										"LEFT JOIN ( SELECT `HotelID`,`SNum`,`DNum`,`QNum` " +
													"FROM `Hotels` " +
													") as hotels_subtable " +
										"ON `hotels_subtable`.`HotelID`=`rooms_subtable`.`HotelID` " +
										"WHERE IF(`RoomType`='Single',`SNum`=`c1`,1) AND " +
												"IF(`RoomType`='Double',`DNum`=`c1`,1) AND " +
												"IF(`RoomType`='Quad',`QNum`=`c1`,1) " +
										") AND " +
						"`hotelStar`=? " + 
					"ORDER BY ?*`SPrice`+?*`DPrice`+?*`QPrice` DESC;");
            prstmtHotel.setBytes(1, dateIsAvailableBytes);
            prstmtHotel.setBytes(2, dateIsAvailableBytes);
            prstmtHotel.setInt(3, hotelStar);
            prstmtHotel.setInt(4, sNumQuery);
            prstmtHotel.setInt(5, dNumQuery);
            prstmtHotel.setInt(6, qNumQuery);
//            prstmtHotel.setInt(3, sNumQuery);
//            prstmtHotel.setInt(4, dNumQuery);
//            prstmtHotel.setInt(6, qNumQuery);
            resultSetHotel = prstmtHotel.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSetHotel != null) {
            try {
                while (resultSetHotel.next()){
                    hotels.add(new Hotel(
                    					resultSetHotel.getInt("HotelId"),
                    					resultSetHotel.getInt("HotelStar"),
                                        resultSetHotel.getString("Street-Address"),
                                        resultSetHotel.getString("Locality"),
                                        resultSetHotel.getInt("SPrice"),
                                        resultSetHotel.getInt("DPrice"),
                                        resultSetHotel.getInt("QPrice")
                                        )
                                );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hotels;
    }

    public ArrayList<Hotel> getHotels(){
        System.out.print("[dbUtil] DatabaseHotel getHotels().\n");
        ResultSet resultSetHotel = null;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        try {
        	prstmtHotel = conn.prepareStatement("SELECT * FROM `Hotels`");
            resultSetHotel = prstmtHotel.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSetHotel != null) {
            try {
                while (resultSetHotel.next()){
                    hotels.add(new Hotel(
                    					resultSetHotel.getInt("HotelId"),
                    					resultSetHotel.getInt("HotelStar"),
                                        resultSetHotel.getString("Street-Address"),
                                        resultSetHotel.getString("Locality"),
                                        resultSetHotel.getInt("SPrice"),
                                        resultSetHotel.getInt("DPrice"),
                                        resultSetHotel.getInt("QPrice")
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
        Integer totalHotelNumber = -1;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT `HotelID` FROM `Hotels` order by `HotelID` ASC;");
            while (resultSet.next()) {
            	totalHotelNumber = Integer.parseInt(resultSet.getString("HotelID"));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber + 1;
    }

    public byte[] setBit(byte[] source, byte target, Integer startDate, Integer endDate) {
    	byte[] update = source;
    	for(int i=startDate ; i<endDate ; i++) {
    		update[i] = (byte)target;
    	}
    	return update;
    }
}
