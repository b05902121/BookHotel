package main;
import java.io.IOException;
import java.sql.SQLException;

import controller.Router;
import databaseUtil.DatabaseBuildAllTables;
import main.ConfigPropertyValues;

public class Main {
    public static void main(String[] args) {
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
        ConfigPropertyValues properties = new ConfigPropertyValues();
        Boolean forceDropTable = null;
        try {
            forceDropTable = properties.getPropValues();
        } catch (IOException e) {
            e.printStackTrace();
        }
        databaseBuildAllTables.start(forceDropTable);
        if(forceDropTable == Boolean.TRUE) {
            /* if you want to insert InsertDefaultData.sql (when test login/signin)*/
            databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
            /* if you want to insert Json Data (when test book hotel) */
            databaseBuildAllTables.insertJsonData();
            
            // change forceDropTable of config.properties into FALSE
            properties.updateConfigProperties("FALSE");
        }
        
        try {
            databaseBuildAllTables.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Router.getInstance().start();
    }
}
