package controller;

import javax.swing.JFrame;

import view.SearchResultView;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import main.Hotel;
import main.Order;
import main.UserSession;
import java.util.Date;
import view.ConfirmView;
import model.OrderModel;

public class ConfirmOrderController extends BaseController {
	private ConfirmView confirmView = new ConfirmView();
	private OrderModel orderModel;
	public ConfirmOrderController() {
		orderModel = new OrderModel();
	}
	
	public void show(JFrame frame) {
        confirmView.setProperty(this, frame);
        frame.setVisible(true);
    }
	public void returnLastPage() {
		Router.getInstance().showSearchResultView();
	}
	public void confirmOrder() {
		Order tmpOrder = UserSession.getInstance(true).getCacheOrder();
		Integer sNum = tmpOrder.getsNum();
		Integer dNum = tmpOrder.getdNum();
		Integer qNum = tmpOrder.getqNum();
		Integer totalPrice = tmpOrder.getTotalPrice();
		Integer orderPrice = tmpOrder.getTotalPrice();
		Integer hotelId = tmpOrder.getHotelId();
		ArrayList<Date> orderDate = UserSession.getInstance(true).getOrderDate();
		String username = UserSession.getInstance(true).getUsername();
		
		// delegate to model
		// ...
		Order order = null;
		try {
			order = orderModel.insertOrder(username, hotelId, orderDate.get(0), orderDate.get(1), sNum, dNum, qNum, totalPrice);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (order == null) {
			System.out.println("Something Wrong");
			Router.getInstance().showMenu();
		}
		UserSession.getInstance(true).cleanOrderCache();
		
		// store order in usersession
		UserSession.getInstance(true).addOrder(order);
		
		System.out.println("Success Order!");
		System.out.println(String.format( "Order Id : %d, Order username: %s, Order Price: %d", order.getOrderId(), order.getUsername(), order.getTotalPrice()));
		Router.getInstance().showMenu();
	}
}
