package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import view.QueryView;
import main.Hotel;
import main.Room;
import java.util.Date;

public class QueryController extends BaseController {
	private RoutingController router;
	private QueryView queryView = new QueryView();
	
	public QueryController(RoutingController router) {
        this.router = router;
    }
	
	public void show(JFrame frame) {
//		ArrayList<Hotel> fakeHotelInfo = makeFakeHotelInfo();	
        queryView.setProperty(this, frame);
        frame.setVisible(true);
    }
	
	public void searchMatchHotel(int selectHotelStar, int singelNum, int doubleNum, int quadNum, Date checkInDate, Date checkOutDate) {
		
		this.clearFrame(queryView.frame);
		this.router.showSearchResultView();
	}
	
}
