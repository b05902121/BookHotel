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
}
