package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import view.QueryView;
import main.Hotel;
import main.Room;

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
	
}
