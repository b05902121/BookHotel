package test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.RoutingController;
import databaseUtil.DatabaseBuildAllTables;
import main.Hotel;
import model.SearchModel;

public class TestSearchModel {

    public TestSearchModel() throws SQLException {
        System.out.println("initialize TestSearchModel");
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
//        Boolean forceDropTable = false;
//        databaseBuildAllTables.start(forceDropTable);

        databaseBuildAllTables.closeConnection();
    }
    
    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String retDate_str = date;
        Date retDate = myFormat.parse(retDate_str);
        return retDate;
    }

    public static void main(String[] args) throws ParseException, SQLException {
        SearchModel searchModel = new SearchModel();
        Integer hotelStar = 4;
        Date startDate = getDate("01 01 2019");
        Date endDate = getDate("05 01 2019");
        Integer sNum = 1;
        Integer dNum = 2;
        Integer qNum = 3;
        ArrayList<Hotel> retHotelList = searchModel.SearchAvailableRoom(hotelStar, startDate, endDate, sNum, dNum, qNum);
        if (retHotelList != null) {System.out.println("got results");}
        for (Hotel h:retHotelList) {
            System.out.println("-------------------------------------------------");
            System.out.printf("hotelStar: %d\n", h.getHotelStar());
            System.out.printf("Price   single: %d, double: %d, quad: %d\n", h.getSingleRoomPrice(), h.getDoubleRoomPrice(), h.getQuadRoomPrice());
        }
    }
}