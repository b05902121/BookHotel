package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import databaseUtil.DatabaseOrder;

public class OrderBaseModel {
    
    DatabaseOrder dbOrder = null;
    protected SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
    protected String pivotDate_str = "01 01 2020";
    
    public OrderBaseModel() {
        try {
            this.dbOrder = new DatabaseOrder("config/jdbc.properties");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int datetoint(Date date) throws ParseException {
        Date pivotDate = myFormat.parse(pivotDate_str);
        long diff = date.getTime() - pivotDate.getTime();
        //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public Date intToDate(int dateOffset) throws ParseException {
        Date pivotDate = myFormat.parse(pivotDate_str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(pivotDate);
        cal.add(Calendar.DATE, dateOffset);
        return cal.getTime();
    }
    
    public String intToDateString(int dateOffset) throws ParseException {
        return myFormat.format(intToDate(dateOffset)).replace(" ", "-");
    }
}
