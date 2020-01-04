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
    public QueryController() throws ParseException, SQLException {
    	searchModel = new SearchModel();
    }

    public void show(JFrame frame) {
        //ArrayList<Hotel> fakeHotelInfo = makeFakeHotelInfo();	
        queryView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void searchMatchHotel(int selectHotelStar, int singelNum, int doubleNum, int quadNum, Date checkInDate, Date checkOutDate) throws ParseException {
    	ArrayList<Hotel> resultHotel = searchModel.SearchAvailableRoom(selectHotelStar, checkInDate, checkOutDate, singelNum, doubleNum, quadNum);
//    	System.out.println(resultHotel);
    	UserSession session = UserSession.getInstance(true);
    	session.setResultHotel(resultHotel);
    	Router.getInstance().showSearchResultView();
    }
}
