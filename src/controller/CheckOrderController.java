package controller;

import javax.swing.JFrame;

import view.CheckOrderView;

public class CheckOrderController extends BaseController {
    private CheckOrderView checkOrderView = new CheckOrderView();
    public CheckOrderController() {}

    @Override
    public void show(JFrame frame) {
        checkOrderView.setProperty(this, frame);
        frame.setVisible(true);
    }
    
    public void showCheckOrderResult(int selectedRow) {
        Router.getInstance().showCheckOrderResultView();
    }
    
    public void showMenu() {
        Router.getInstance().showMenu();
    }
}
