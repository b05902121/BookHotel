package controller;

import javax.swing.JFrame;

import view.SearchResultView;

public class SearchResultController extends BaseController{
	private RoutingController router;
	private SearchResultView searchResultView = new SearchResultView();
	
	public SearchResultController(RoutingController router) {
		this.router = router;
	}
	public void show(JFrame frame) {
		searchResultView.setProperty(this, frame);
        frame.setVisible(true);
    }
}
