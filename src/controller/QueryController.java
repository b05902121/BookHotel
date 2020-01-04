package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import view.QueryView;
import main.Hotel;
import main.Room;
import java.util.Date;
import model.SearchModel;
import java.sql.SQLException;
import java.text.ParseException;
import main.UserSession;

public class QueryController extends BaseController{
    private QueryView queryView = new QueryView();
    private SearchModel searchModel;
    public ArrayList<Hotel> hotelInfo = new ArrayList<Hotel>();
    public QueryController() throws ParseException, SQLException {
    	searchModel = new SearchModel();
    }

    public void show(JFrame frame) {
        this.hotelInfo = searchModel.getAllHotels();	
        queryView.setProperty(this, frame);
        frame.setVisible(true);
    }
    public void getHotelByStar(int star) {
    	Integer hotelStar = Integer.valueOf(star);
    	this.hotelInfo = searchModel.getHotelsbyHotelStar(hotelStar);
    }
    public void searchMatchHotel(int selectHotelStar, int singelNum, int doubleNum, int quadNum, Date checkInDate, Date checkOutDate) throws ParseException {
    	ArrayList<Hotel> resultHotel = searchModel.SearchAvailableRoom(selectHotelStar, checkInDate, checkOutDate, singelNum, doubleNum, quadNum);
//    	System.out.println(resultHotel);
    	UserSession session = UserSession.getInstance(true);
    	session.setResultHotel(resultHotel);
    	session.setOrderDate(checkInDate, checkOutDate);
    	Router.getInstance().showSearchResultView();
    }
    public void returnMenu() {
    	Router.getInstance().showMenu();
    }
}
