package test;

import java.sql.*;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class DatabaseUtilUserTest {
    public static void main(String[] args) {
        try {
            /*  Initialize databases and tables */
            DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
            if (!databaseBuildAllTables.getConnection().isClosed()) {
                System.out.print("[LOG] databaseBuildAllTables successfully start.\n");
            }
            databaseBuildAllTables.start();
            databaseBuildAllTables.insertDefaultData();
            databaseBuildAllTables.closeConnection();

            ResultSet resultSet;

            /*  Insert one user data and Select one data */
            DatabaseUser databaseUser = new DatabaseUser("config/jdbc.properties");
            if (!databaseUser.getConnection().isClosed()) {
                System.out.print("[LOG] DatabaseUser successfully start.\n");
            }
            databaseUser.InsertUser("b05902000", "b05902000_12345");
            resultSet = databaseUser.getUserById("b05902000");
            System.out.print("[LOG] ---- Result start ----\n");
            while (resultSet.next()) {
                System.out.print("[LOG] " + resultSet.getString("UID") + "\t"
                        + resultSet.getString("password") + '\n');
            }
            System.out.print("[LOG] ---- Result end ----\n");
            databaseUser.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
