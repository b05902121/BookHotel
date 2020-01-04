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

public class SearchResultController extends BaseController{
    private SearchResultView searchResultView = new SearchResultView();
    public SearchResultController() {
    }

    public void show(JFrame frame) {
        searchResultView.setProperty(this, frame);
        frame.setVisible(true);
    }
    public void returnLastPage() throws ParseException, SQLException {
    	Router.getInstance().showQueryHotelView();
    }
    public void returnMenuPage() {
    	Router.getInstance().showMenu();
    }
    public void confirmOrder(int hotelId, int totalPrice) {
    	UserSession session = UserSession.getInstance(true);
    	Date checkInDate = session.getOrderDate().get(0);
    	Date checkOutDate  = session.getOrderDate().get(1);
    	int[] reservedNum = session.getReserveRoomNum();
    	Integer fakeVal = Integer.valueOf(-1);
    	Integer sNum = Integer.valueOf(reservedNum[0]);
    	Integer dNum = Integer.valueOf(reservedNum[1]);
    	Integer qNum = Integer.valueOf(reservedNum[2]);
    	Integer hotelID = Integer.valueOf(hotelId);
    	Integer orderPrice = Integer.valueOf(totalPrice);
    	Order tmpOrder = new Order(fakeVal, session.getUsername(), hotelID, fakeVal, fakeVal,sNum, 
    			dNum, qNum, orderPrice);
    	session.setOrderCache(tmpOrder);
    	Router.getInstance().showConfirmOrder();
    }
}
