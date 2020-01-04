package test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.Router;
import databaseUtil.DatabaseBuildAllTables;
import main.Hotel;
import model.SearchModel;

public class TestSearchModel {

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String retDate_str = date;
        Date retDate = myFormat.parse(retDate_str);
        return retDate;
    }

    public static void main(String[] args) throws ParseException, SQLException {
        
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
        
        SearchModel searchModel = new SearchModel();
        Integer hotelStar = 3;
        Date startDate = getDate("01 01 2019");
        Date endDate = getDate("03 01 2019");
        Integer sNum = 10;
        Integer dNum = 15;
        Integer qNum = 25;
        ArrayList<Hotel> retHotelList = searchModel.SearchAvailableRoom(hotelStar, startDate, endDate, sNum, dNum, qNum);
        if (retHotelList != null) {
            System.out.print("[Test] Got results: ");
            System.out.println(retHotelList);
        }
        for (Hotel h:retHotelList) {
            System.out.println("-------------------------------------------------");
            System.out.printf("hotelStar: %d\n", h.getHotelStar());
            System.out.printf("Price   single: %d, double: %d, quad: %d\n", h.getSingleRoomPrice(), h.getDoubleRoomPrice(), h.getQuadRoomPrice());
        }
    }
}
