package test;

import java.sql.*;
import java.util.ArrayList;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseHotel;
import main.Hotel;

public class DatabaseUtilHotelTest{
    public static void main(String[] args) {
        try {
            /*  Initial databases and tables */
            DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
            if(!databaseBuildAllTables.getConnection().isClosed()) {
                System.out.print("[Test] databaseBuildAllTables successfully start.\n");
            }

            /* if you execute in the first time */
            Boolean forceDropTable = true;
            databaseBuildAllTables.start(forceDropTable);
            databaseBuildAllTables.insertJsonData();
            /* if you have been executed */
//            Boolean forceDropTable = false;
//            databaseBuildAllTables.start(forceDropTable);

            databaseBuildAllTables.closeConnection();

            ArrayList<Hotel> hotels = null;
            DatabaseHotel databaseHotel = new DatabaseHotel("config/jdbc.properties");
            Integer totalHotelNumber = databaseHotel.getTotalHotelNumber();
            System.out.print("[Test] totalHotelNumber = " + totalHotelNumber + "\n");
            // date use [dateStart, dateEnd], both include with for loop;
            // So [1, 3] will become [011100000....], because a for loop will execute in for(i=1 ; 0 <= 3; i++){}, means day 1st~3rd
            hotels = databaseHotel.getHotelsByInformation(3,1,3,1,24,24);
            for(Hotel hotel: hotels){
                printHotel(hotel);
            }
            System.out.print("[Test] total number of hotels for specific hotelStar = " + hotels.size() + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printHotel(Hotel hotel){
        System.out.print("[Test] "
                + hotel.getHotelId() + "\t"
                + hotel.getHotelStar() + "\t"
                + hotel.getLocality() + "\t"
                + hotel.getAddress() + '\n');
    }
}
