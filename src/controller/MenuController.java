package controller;

import javax.swing.JFrame;

import main.UserSession;
import view.MenuView;

public class MenuController extends BaseController {
    private MenuView menuView = new MenuView();
    // MenuModel menuModel = new MenuModel(this);

    public MenuController(RoutingController router) {
        this.router = router;
    }

    public void show(JFrame frame) {
        menuView.setProperty(this, frame);
        frame.setVisible(true);
        UserSession.getInstance(true).testingMethod();
    }
    
    public void logout() {
        UserSession.getInstance(true).logout();
        clearFrame(menuView.frame);
        router.showSignInView();
    }
}
