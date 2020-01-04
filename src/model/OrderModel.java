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
        String pivotDate_str = "01 01 2020";
        Date pivotDate = myFormat.parse(pivotDate_str);
        long diff = date.getTime() - pivotDate.getTime();
        //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public Order insertOrder(String username, Integer hotelId, Date startDate, Date endDate, Integer sNum,
            Integer dNum, Integer qNum, Integer totalPrice) throws ParseException {
        Integer startDate_int = datetoint(startDate);
        Integer endDate_int = datetoint(endDate);
        Integer orderId = this.dbOrder.getOrderIdforNewOrder();
        Order order = new Order(orderId, username, hotelId, startDate_int, endDate_int, sNum, dNum, qNum, totalPrice);
        this.dbOrder.insertOrder(order);
        return order;
    }
    
    public ArrayList<Order> findOrderByUsername(String username) {
        ArrayList<Order> orderList = this.dbOrder.getOrderList(username);
        return orderList;
    }
    
    public Boolean reviseOrder(Integer orderId, String username, Integer hotelId, Date startDate, Date endDate, Integer sNum,
            Integer dNum, Integer qNum, Integer totalPrice) throws ParseException {
        Integer startDate_int = datetoint(startDate);
        Integer endDate_int = datetoint(endDate);
        Order oldOrder = null;
        ArrayList<Order> orderList = findOrderByUsername(username);
        for (Order o:orderList) {
            if(o.getOrderId() == orderId) {oldOrder = o;}
        }
        if(startDate_int < oldOrder.getStartDate() || endDate_int > oldOrder.getEndDate()) {
            System.out.println("[model/Order] Invalid start date and end date for revising order!");
            return Boolean.FALSE;
        }
        //System.out.printf("[model/Order] startDate_int: %d, endDate_int: %d\n", startDate_int, endDate_int);
        Order newOrder = new Order(orderId, username, hotelId, startDate_int, endDate_int, sNum, dNum, qNum, totalPrice);
        Boolean ret = this.dbOrder.updateOrder(newOrder);
        return ret;
    }
    
    public void deleteOrder(Integer orderId, String username) {
        Order order = null;
        ArrayList<Order> orderList = findOrderByUsername(username);
        for (Order o:orderList) {
            if(o.getOrderId() == orderId) {order = o;}
        }
        this.dbOrder.deleteOrder(order);
    }
}
