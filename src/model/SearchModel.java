package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import databaseUtil.DatabaseHotel;
import main.Hotel;

public class SearchModel{
    DatabaseHotel dbhotel = null;
    public SearchModel() throws SQLException {
        dbhotel = new DatabaseHotel("config/jdbc.properties");
    }
    
    // 給定hotelStar, startDate, endDate, single num, double num, quad num，db拿出startDate到endDate之間，有這些空房間的hotel資訊
    public ArrayList<Hotel> SearchAvailableRoom(Integer hotelStar, Date startDate, Date endDate, Integer sNum, Integer dNum, Integer qNum) throws ParseException {
        int startDate_int = this.datetoint(startDate);
        int endDate_int = this.datetoint(endDate);
        ArrayList<Hotel> matchHotelList = dbhotel.getHotelsByInformation(hotelStar, startDate_int, endDate_int, sNum, dNum, qNum);
        return matchHotelList;
    }
    
    public ArrayList<Hotel> getAllHotels(){
        return dbhotel.getHotels();
    }
    
    public int datetoint(Date date) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String pivotDate_str = "01 01 2020";
        Date pivotDate = myFormat.parse(pivotDate_str);
        long diff = date.getTime() - pivotDate.getTime();
        //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
