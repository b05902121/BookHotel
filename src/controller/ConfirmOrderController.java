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

public class ConfirmOrderController extends BaseController {
	private ConfirmView confirmView = new ConfirmView();
	public ConfirmOrderController() {}
	
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
		ArrayList<Date> orderDate = UserSession.getInstance(true).getOrderDate();
		String username = UserSession.getInstance(true).getUsername();
		
		// delegate to model
		// ...
		
		UserSession.getInstance(true).cleanOrderCache();
		
		// store order in usersession
		// ...
		System.out.println("Success Order!");
		Router.getInstance().showMenu();
	}
}
