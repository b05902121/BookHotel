package test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseOrder;
import main.Order;
import model.OrderModel;

public class TestOrderModel {

    public static void printOrder(Order order){
        System.out.print("[Test] "
                + order.getOrderId() + "\t"
                + order.getUsername() + "\t"
                + order.getHotelId() + "\t"
                + order.getStartDate() + "\t"
                + order.getEndDate() + "\t"
                + order.getsNum() + "\t"
                + order.getdNum() + "\t"
                + order.getdNum() + "\t"
                + order.getTotalPrice() + "\n");
    }
    
    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String retDate_str = date;
        Date retDate = myFormat.parse(retDate_str);
        return retDate;
    }
    
    public static void main(String[] args) throws ParseException {
        try {
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
            // Boolean forceDropTable = false;
            // databaseBuildAllTables.start(forceDropTable);
    
            databaseBuildAllTables.closeConnection();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        OrderModel orderModel = new OrderModel();
        Date startDate = getDate("01 01 2020");
        Date endDate = getDate("05 01 2020");
        // insert new order
        orderModel.insertOrder("aaaaa", 0, startDate, endDate, 1, 1, 1, 100);
        // check if new order inserted exists
        ArrayList<Order> orderList = orderModel.findOrderByUsername("aaaaa");
        System.out.println("[TEST] get order: should be 0, aaaaa, 0, 0, 4, 1, 1, 1, 100");
        System.out.print(orderList);
        printOrder(orderList.get(0));
        
        Date startDate2 = getDate("02 01 2020");
        Date endDate2 = getDate("04 01 2020");
        // revise order
        Integer orderId = orderList.get(0).getOrderId();
        Boolean ret = orderModel.reviseOrder(orderId, "aaaaa", 0, startDate2, endDate2, 1, 1, 1, 100);
        if(ret == Boolean.TRUE) {System.out.println("[TEST] revise order success");}
        else if(ret == Boolean.FALSE) {System.out.println("[TEST] revise order fail");}
        ArrayList<Order> orderList2 = orderModel.findOrderByUsername("aaaaa");
        System.out.println("[TEST] get order: should be 0, aaaaa, 0, 1, 3, 1, 1, 1, 100");
        System.out.print(orderList2);
        printOrder(orderList2.get(0));
        
        // delete order
        orderModel.deleteOrder(orderId, "aaaaa");
        ArrayList<Order> orderList3 = orderModel.findOrderByUsername("aaaaa");
        System.out.println("[TEST] get order: should be []");
        System.out.print(orderList3);
    }

}
