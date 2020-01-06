package model;

import java.util.ArrayList;

import main.Order;

public class CheckOrderModel extends OrderBaseModel {
    public ArrayList<Order> findOrderByUsername(String username) {
        ArrayList<Order> orderList = this.dbOrder.getOrderList(username);
        return orderList;
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
