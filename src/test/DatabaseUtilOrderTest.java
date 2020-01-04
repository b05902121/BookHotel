package test;

import java.sql.SQLException;
import java.util.ArrayList;

import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseOrder;
import main.Order;

public class DatabaseUtilOrderTest {

	public static void main(String[] args) {
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
//	        Boolean forceDropTable = false;
//	        databaseBuildAllTables.start(forceDropTable);
	
	        databaseBuildAllTables.closeConnection();
	
	        ArrayList<Order> orders = null;
	        DatabaseOrder databaseOrder = new DatabaseOrder("config/jdbc.properties");
	        databaseOrder.insertOrder(new Order(databaseOrder.getOrderIdforNewOrder(),"b05902109",0,0,3,1,1,1,100));
	        databaseOrder.insertOrder(new Order(databaseOrder.getOrderIdforNewOrder(),"b05902109",1,0,3,1,1,1,101));
	        databaseOrder.insertOrder(new Order(databaseOrder.getOrderIdforNewOrder(),"b05902109",2,0,3,1,1,1,102));
	        Integer totalOrderNumber = databaseOrder.getTotalOrderNumber();
	        System.out.print("[Test] totalOrderNumber = " + totalOrderNumber + "\n");
	        orders = databaseOrder.getOrderList("b05902109");
	        System.out.print("[Test] total number of orders for specific UID = " + orders.size() + "\n");
	        for(Order order: orders){
	            printOrder(order);
	        }
	        
	        Integer deleteOrder_OrderID = 0;
	        Order deleteOrder = new Order(deleteOrder_OrderID,"b05902109",0,0,3,1,1,1,100);
	        System.out.print("[Test] delete order orderID = " + deleteOrder_OrderID + "\n");
	        databaseOrder.deleteOrder(deleteOrder);
	        totalOrderNumber = databaseOrder.getTotalOrderNumber();
	        System.out.print("[Test] totalOrderNumber = " + totalOrderNumber + "\n");
	        orders = databaseOrder.getOrderList("b05902109");
	        System.out.print("[Test] total number of orders for specific UID = " + orders.size() + "\n");
	        for(Order order: orders){
	            printOrder(order);
	        }
	        
	        Integer update_OrderID = 1;
	        Order updateOrder = new Order(update_OrderID,"b05902109",9,9,5,9,9,9,900);
	        System.out.print("[Test] delete order orderID = " + update_OrderID + "\n");
	        databaseOrder.updateOrder(updateOrder);
	        orders = databaseOrder.getOrderList("b05902109");
	        for(Order order: orders){
	            printOrder(order);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

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
}
