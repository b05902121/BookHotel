package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import main.Order;
import databaseUtil.DatabaseOrder;

public class OrderModel {
    
    DatabaseOrder dbOrder = null;
    
    public OrderModel() {
        try {
            this.dbOrder = new DatabaseOrder("config/jdbc.properties");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int datetoint(Date date) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String pivotDate_str = "01 01 2019";
        Date pivotDate = myFormat.parse(pivotDate_str);
        long diff = date.getTime() - pivotDate.getTime();
        //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void insertOrder(String username, Integer hotelId, Date startDate, Date endDate, Integer sNum,
            Integer dNum, Integer qNum, Integer totalPrice) throws ParseException {
        Integer startDate_int = datetoint(startDate);
        Integer endDate_int = datetoint(endDate);
        Integer orderId = this.dbOrder.getOrderIdforNewOrder();
        Order order = new Order(orderId, username, hotelId, startDate_int, endDate_int, sNum, dNum, qNum, totalPrice);
        this.dbOrder.insertOrder(order);
    }
    
    public ArrayList<Order> findOrderByUsername(String username) {
        ArrayList<Order> orderList = this.dbOrder.getOrderList(username);
        return orderList;
    }
}
