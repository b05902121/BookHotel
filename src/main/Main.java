package main;
import java.sql.SQLException;

import controller.RoutingController;
import databaseUtil.DatabaseBuildAllTables;

public class Main {
    public static void main(String[] args) {
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
        
        /* if you execute in the first time */
        Boolean forceDropTable = true;
        /* if you have been executed */
//        Boolean forceDropTable = false;

        databaseBuildAllTables.start(forceDropTable);
        
        /* if you want to insert InsertDefaultData.sql (when test login/signin)*/
        databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
        /* if you want to insert Json Data (when test book hotel) */
//        databaseBuildAllTables.insertJsonData();

        try {
            databaseBuildAllTables.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RoutingController router = new RoutingController();
        router.start();
    }
}
