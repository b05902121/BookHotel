package controller;

import javax.swing.JFrame;
import java.sql.SQLException;
import java.text.ParseException;

import main.UserSession;
import view.MenuView;

public class MenuController extends BaseController {
    private MenuView menuView = new MenuView();
    // MenuModel menuModel = new MenuModel(this);

    public MenuController() {}

    @Override
    public void show(JFrame frame) {
        menuView.setProperty(this, frame);
        frame.setVisible(true);
        UserSession.getInstance(true).testingMethod();
    }
    

    public void logout() {
        UserSession.getInstance(true).logout();
        Router.getInstance().showSignInView();
    }

    public void showQueryHotelView() throws ParseException, SQLException {
        Router.getInstance().showQueryHotelView();
    }
    
    public void showcheckOrderView() {
        Router.getInstance().showCheckOrderView();
    }
}
