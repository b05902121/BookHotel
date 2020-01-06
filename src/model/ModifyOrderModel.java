package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import main.Order;

public class ModifyOrderModel extends CheckOrderModel{
    
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
}
