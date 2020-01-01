package test;

import java.sql.*;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class DatabaseUtilUserTest {
    public static void main(String[] args) {
        try {
            /*  Initial databases and tables */
            DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
            if (!databaseBuildAllTables.getConnection().isClosed()) {
                System.out.print("[LOG] databaseBuildAllTables successfully start.\n");
            }
            /* if you execute in the first time */
            Boolean forceDropTable = true;
            /* if you have been executed */
//            Boolean forceDropTable = false;

            databaseBuildAllTables.start(forceDropTable);
            
            /* if you want to insert InsertDefaultData.sql (when test login/signin)*/
            databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
            /* if you want to insert Json Data (when test book hotel) */
//            databaseBuildAllTables.insertJsonData();

            databaseBuildAllTables.closeConnection();

            ResultSet resultSet;

            /*  Insert one user data and Select one data */
            DatabaseUser databaseUser = new DatabaseUser("config/jdbc.properties");
            if (!databaseUser.getConnection().isClosed()) {
                System.out.print("[Test] DatabaseUser successfully start.\n");
            }
            databaseUser.InsertUser("b05902000", "b05902000");
            resultSet = databaseUser.getUserById("b05902000");
            System.out.print("[Test] ---- Result start ----\n");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("UID") + "\t"
                        + resultSet.getString("password") + '\n');
            }
            System.out.print("[Test] ---- Result end ----\n");
            databaseUser.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
