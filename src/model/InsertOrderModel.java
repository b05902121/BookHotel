package model;

import java.text.ParseException;
import java.util.Date;

import main.Order;

public class InsertOrderModel extends OrderBaseModel {
    public Order insertOrder(String username, Integer hotelId, Date startDate, Date endDate, Integer sNum,
            Integer dNum, Integer qNum, Integer totalPrice) throws ParseException {
        Integer startDate_int = datetoint(startDate);
        Integer endDate_int = datetoint(endDate);
        Integer orderId = this.dbOrder.getOrderIdforNewOrder();
        Order order = new Order(orderId, username, hotelId, startDate_int, endDate_int, sNum, dNum, qNum, totalPrice);
        this.dbOrder.insertOrder(order);
        return order;
    }
}
