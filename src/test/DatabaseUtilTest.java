package test;

import java.sql.*;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseHotel;
import databaseUtil.DatabaseUser;

public class DatabaseUtilTest{
    public static void main(String[] args) {
        try {
            /*  Initial databases and tables */
            DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("jdbc.properties");
            if(!databaseBuildAllTables.getConnection().isClosed()) {
                System.out.print("[LOG] databaseBuildAllTables successfully start.\n");
            }
            databaseBuildAllTables.start();
            databaseBuildAllTables.insertDefaultData();
            databaseBuildAllTables.closeConnection();

            ResultSet resultSet;

//            /*  Insert one user data and Select one data */
//            DatabaseUser databaseUser = new DatabaseUser("jdbc.properties");
//            if(!databaseUser.getConnection().isClosed()) {
//                System.out.print("[LOG] DatabaseUser successfully start.\n");
//            }
//            databaseUser.InsertUser("b05902000", "b05902000");
//            resultSet = databaseUser.getUserById("b05902000");
//            System.out.print("[LOG] ---- Result start ----\n");
//            while (resultSet.next()){
//                System.out.print(resultSet.getString("UID") + "\t"
//                                + resultSet.getString("password") + '\n');
//            }
//            System.out.print("[LOG] ---- Result end ----\n");
//            databaseUser.closeConnection();


            /*  Set default user data to users table and select one data    */
            DatabaseHotel databaseHotel = new DatabaseHotel("jdbc.properties");
            if(!databaseHotel.getConnection().isClosed()) {
                System.out.print("[LOG] DatabaseHotel successfully start.\n");
            }
            System.out.print("[LOG] Test getAllHotels().\n");
            resultSet = databaseHotel.getAllHotels();
            printHotelResultSet(resultSet);
            System.out.print("[LOG] Test insertHotel().\n");
            databaseHotel.insertHotel("Dogggg Hotel", 1, 1, 1, "Add this one.");
            resultSet = databaseHotel.getAllHotels();
            printHotelResultSet(resultSet);
            System.out.print("[LOG] Test getHotelsByHotelName(\"Apple Hotel\").\n");
            resultSet = databaseHotel.getHotelsByHotelName("Apple Hotel");
            printHotelResultSet(resultSet);
            System.out.print("[LOG] Test getHotelsByAvailableRoomTypeNum(\"SingleRoom\").\n");
            resultSet = databaseHotel.getHotelsByAvailableRoomTypeNum("SingleRoom");
            printHotelResultSet(resultSet);
            System.out.print("[LOG] Test getHotelsByAvailableRoomTypeNum(\"DoubleRoom\").\n");
            resultSet = databaseHotel.getHotelsByAvailableRoomTypeNum("DoubleRoom");
            printHotelResultSet(resultSet);
            databaseHotel.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printHotelResultSet(ResultSet resultSet) throws SQLException {
        System.out.print("[LOG] ---- Result start ----\n");
        while (resultSet.next()){
            System.out.print(resultSet.getString("HotelName") + "\t"
                    + resultSet.getString("HotelID") + "\t"
                    + resultSet.getString("SingleRoomNum") + "\t"
                    + resultSet.getString("DoubleRoomNum") + "\t"
                    + resultSet.getString("QuadRoomNum") + "\t"
                    + resultSet.getString("note") + '\n');
        }
        System.out.print("[LOG] ---- Result end ----\n");
    }
}
