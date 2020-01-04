package databaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import main.Order;

public class DatabaseOrder extends DatabaseConnect {
    private PreparedStatement prstmtOrder = null;
    private PreparedStatement prstmtRoom = null;

    public DatabaseOrder(String configFile) throws SQLException {
        super(configFile);
    }
    
    public void insertOrder(Order order) {
    	System.out.print("[dbUtil] DatabaseOrder insertOrder()\n");
    	ResultSet resultSet = null;
    	/* Insert into Order table */
        try {
	    	prstmtOrder = conn.prepareStatement("INSERT INTO `Orders`(`OrderID`,`UID`,`HotelID`,`StartDate`,`EndDate`,`SNum`,`DNum`,`QNum`,`TotalPrice`) VALUES (?,?,?,?,?,?,?,?,?);");
	    	prstmtOrder.setInt(1, order.getOrderId());
	    	prstmtOrder.setString(2, order.getUsername());
	    	prstmtOrder.setInt(3, order.getHotelId());
	    	prstmtOrder.setInt(4, order.getStartDate());
	    	prstmtOrder.setInt(5, order.getEndDate());
	    	prstmtOrder.setInt(6, order.getsNum());
	    	prstmtOrder.setInt(7, order.getdNum());
	    	prstmtOrder.setInt(8, order.getqNum());
	    	prstmtOrder.setInt(9, order.getTotalPrice());
	        int numUpd = prstmtOrder.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
        /* Update Room table */
        try {
        	prstmtRoom = conn.prepareStatement("SELECT `RoomID`,`RoomType`,`DateIsAvailable` FROM `Rooms` WHERE `HotelID`=?;");
	        prstmtRoom.setInt(1, order.getHotelId());
        	resultSet = prstmtRoom.executeQuery();
        	prstmtRoom = conn.prepareStatement("UPDATE `Rooms` set `DateIsAvailable`=? WHERE `RoomID`=?;");
	        Integer sCount = order.getsNum(), dCount = order.getqNum(), qCount = order.getqNum();
	        while(resultSet.next()) {
        		byte[] dateIsAvailableBytes = resultSet.getBytes("DateIsAvailable");
        		String roomType = resultSet.getString("RoomType");
        		if(sCount == 0 && dCount == 0 && qCount == 0) {
        			break;
        		}
        		else if(roomType.equals("Single") && sCount > 0 && match(dateIsAvailableBytes, (byte)1, order.getStartDate(), order.getEndDate())) {
	        		sCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Double") && dCount > 0 && match(dateIsAvailableBytes, (byte)1, order.getStartDate(), order.getEndDate())) {
	        		dCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Single") && qCount > 0 && match(dateIsAvailableBytes, (byte)1, order.getStartDate(), order.getEndDate())) {
	        		qCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        }
            int[] countRoom = prstmtRoom.executeBatch();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return;
    }

    public ArrayList<Order> getOrderList(String username) {
    	System.out.print("[dbUtil] DatabaseOrder getOrderList()\n");
    	ArrayList<Order> orderList = new ArrayList<Order>();
    	ResultSet resultSetOrder = null;
    	try {
    		prstmtOrder = conn.prepareStatement("SELECT * FROM `Orders` WHERE `UID`=? ORDER BY `OrderID` ASC;");
    		prstmtOrder.setString(1, username);
            resultSetOrder = prstmtOrder.executeQuery();
            while(resultSetOrder.next()) {
            	orderList.add(new Order(
            							resultSetOrder.getInt("OrderID"),
            							resultSetOrder.getString("UID"),
            							resultSetOrder.getInt("HotelID"),
            							resultSetOrder.getInt("StartDate"),
            							resultSetOrder.getInt("EndDate"),
            							resultSetOrder.getInt("SNum"),
            							resultSetOrder.getInt("DNum"),
            							resultSetOrder.getInt("QNum"),
            							resultSetOrder.getInt("TotalPrice")
            							));
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	return orderList;
    }
    
    public void updateOrder(Order order) {
    	System.out.print("[dbUtil] DatabaseOrder updateOrder()\n");
    	
        /* Update Room table */
        ResultSet resultSet = null;
        Integer startDateOld, endDateOld, startDateNew = order.getStartDate(), endDateNew = order.getEndDate();
        try {
	        prstmtRoom = conn.prepareStatement("SELECT `StartDate`,`EndDate` FROM `Orders` WHERE `OrderID`=?;");
	        prstmtRoom.setInt(1, order.getOrderId());
        	resultSet = prstmtRoom.executeQuery();
        	resultSet.next();
        	startDateOld = resultSet.getInt("StartDate");
        	endDateOld = resultSet.getInt("EndDate");
        	/* select from rooms */
	        prstmtRoom = conn.prepareStatement("SELECT `RoomID`,`RoomType`,`DateIsAvailable` FROM `Rooms` WHERE `HotelID`=?;");
	        prstmtRoom.setInt(1, order.getHotelId());
        	resultSet = prstmtRoom.executeQuery();
        	prstmtRoom = conn.prepareStatement("UPDATE `Rooms` set `DateIsAvailable`=? WHERE `RoomID`=?;");
	        Integer sCount = order.getsNum(), dCount = order.getqNum(), qCount = order.getqNum();
	        while(resultSet.next()) {
        		byte[] dateIsAvailableBytes = resultSet.getBytes("DateIsAvailable");
        		String roomType = resultSet.getString("RoomType");
        		if(sCount == 0 && dCount == 0 && qCount == 0) {
        			break;
        		}
        		else if(roomType.equals("Single") && sCount > 0 && match(dateIsAvailableBytes, (byte)0, startDateOld, endDateOld)) {
	        		sCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, startDateOld, endDateOld);
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, startDateNew, endDateNew);
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Double") && dCount > 0 && match(dateIsAvailableBytes, (byte)0, startDateOld, endDateOld)) {
	        		dCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, startDateOld, endDateOld);
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, startDateNew, endDateNew);
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Single") && qCount > 0 && match(dateIsAvailableBytes, (byte)0, startDateOld, endDateOld)) {
	        		qCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, startDateOld, endDateOld);
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)0, startDateNew, endDateNew);
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        }
            int[] countRoom = prstmtRoom.executeBatch();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

    	/* Update Order table */
        try {
	    	prstmtOrder = conn.prepareStatement("UPDATE `Orders` set `UID`=?,`HotelID`=?,`StartDate`=?,`EndDate`=?,`SNum`=?,`DNum`=?,`QNum`=? WHERE `OrderID`=?;");
	    	prstmtOrder.setString(1, order.getUsername());
	    	prstmtOrder.setInt(2, order.getHotelId());
	    	prstmtOrder.setInt(3, order.getStartDate());
	    	prstmtOrder.setInt(4, order.getEndDate());
	    	prstmtOrder.setInt(5, order.getsNum());
	    	prstmtOrder.setInt(6, order.getdNum());
	    	prstmtOrder.setInt(7, order.getqNum());
	    	prstmtOrder.setInt(8, order.getOrderId());
	        int numUpd = prstmtOrder.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

    }
    
    public void deleteOrder(Order order) {
    	System.out.print("[dbUtil] DatabaseOrder deleteOrder()\n");
        /* Update Room table */
        ResultSet resultSet = null;
        try {
        	/* select from rooms */
	        prstmtRoom = conn.prepareStatement("SELECT `RoomID`,`RoomType`,`DateIsAvailable` FROM `Rooms` WHERE `HotelID`=?;");
	        prstmtRoom.setInt(1, order.getHotelId());
        	resultSet = prstmtRoom.executeQuery();
        	prstmtRoom = conn.prepareStatement("UPDATE `Rooms` set `DateIsAvailable`=? WHERE `RoomID`=?;");
	        Integer sCount = order.getsNum(), dCount = order.getqNum(), qCount = order.getqNum();
	        while(resultSet.next()) {
        		byte[] dateIsAvailableBytes = resultSet.getBytes("DateIsAvailable");
        		String roomType = resultSet.getString("RoomType");
        		if(sCount == 0 && dCount == 0 && qCount == 0) {
        			break;
        		}
        		else if(roomType.equals("Single") && sCount > 0 && match(dateIsAvailableBytes, (byte)0, order.getStartDate(), order.getEndDate())) {
	        		sCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Double") && dCount > 0 && match(dateIsAvailableBytes, (byte)0, order.getStartDate(), order.getEndDate())) {
	        		dCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        	else if(roomType.equals("Single") && qCount > 0 && match(dateIsAvailableBytes, (byte)0, order.getStartDate(), order.getEndDate())) {
	        		qCount --;
	        		dateIsAvailableBytes = setBit(dateIsAvailableBytes, (byte)1, order.getStartDate(),order.getEndDate());
	        		prstmtRoom.setBytes(1, dateIsAvailableBytes);
	        		prstmtRoom.setInt(2, resultSet.getInt("RoomID"));
	        		prstmtRoom.addBatch();
	        	}
	        }
            int[] countRoom = prstmtRoom.executeBatch();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	/* Update Order table */
        try {
	    	prstmtOrder = conn.prepareStatement("DELETE FROM `Orders` WHERE `OrderID`=?;");
	    	prstmtOrder.setInt(1, order.getOrderId());
	        int numUpd = prstmtOrder.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    }

    public Integer getOrderIdforNewOrder(){
    	System.out.print("[dbUtil] DatabaseOrder getMaxOrderNumber()\n");
        Integer orderID = 0;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT `OrderID` FROM `Orders` ORDER BY `OrderID` ASC;");
            while(resultSet.next()) {
            	if(resultSet.getInt("OrderID") == orderID){
            		orderID ++;
            	}
            	else {
            		break;
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderID;
    }

    public Integer getTotalOrderNumber(){
    	System.out.print("[dbUtil] DatabaseOrder getMaxOrderNumber()\n");
        Integer totalHotelNumber = 0;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT count(`OrderID`) as c FROM `Orders`;");
            while(resultSet.next()) {
            	totalHotelNumber = resultSet.getInt("c");
            	break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalHotelNumber;
    }
    
    public boolean match(byte[] source, byte target, Integer startDate, Integer endDate) {
    	for(int i=startDate ; i<endDate ; i++) {
    		if(source[i] != target) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public byte[] setBit(byte[] source, byte target, Integer startDate, Integer endDate) {
    	byte[] update = source;
    	for(int i=startDate ; i<endDate ; i++) {
    		update[i] = (byte)target;
    	}
    	return update;
    }
}
