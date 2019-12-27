import java.io.*;
import java.sql.*;

public class DatabaseUtilTest{
    public static void main(String[] args) {
        try {
            /*  Initial databases and tables */
            DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("jdbc.properties");
            if(!databaseBuildAllTables.getConnection().isClosed()) {
                System.out.print("[LOG] databaseBuildAllTables start.\n");
            }
            databaseBuildAllTables.start();
            databaseBuildAllTables.closeConnection();

            /*  Set default user data to users table and select one data    */
            DatabaseUser databaseUser = new DatabaseUser("jdbc.properties");
            if(!databaseUser.getConnection().isClosed()) {
                System.out.print("[LOG] DatabaseUser start.\n");
            }
            databaseUser.insertDefaultData();
            databaseUser.InsertUser("b05902000", "b05902000");
            ResultSet resultSet = databaseUser.getUserById("b05902000");
            System.out.print("[LOG] ---- Result start ----\n");
            while (resultSet.next()){
                System.out.print(resultSet.getString("UID") + " - "
                                + resultSet.getString("UID") + '\n');
            }
            System.out.print("[LOG] ---- Result end ----\n");
            databaseUser.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}