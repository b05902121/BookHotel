package controller;

import javax.swing.JFrame;

import view.SearchResultView;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import main.Hotel;

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
}
