package main;
import java.sql.SQLException;

import controller.RoutingController;
import databaseUtil.DatabaseBuildAllTables;

public class Main {
    public static void main(String[] args) {
    DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
    Boolean forceDropTable = true;
    databaseBuildAllTables.start(forceDropTable);
    databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
    try {
		databaseBuildAllTables.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
        RoutingController router = new RoutingController();
        router.start();
    }
}
