package controller;

import javax.swing.JFrame;

import view.CheckOrderResultView;

public class CheckOrderResultController extends BaseController {
    private CheckOrderResultView checkOrderResultView = new CheckOrderResultView();

    private String hotelName = "hotel1";
    private Integer TotalPrize = 2000;

    public CheckOrderResultController() {}

    @Override
    public void show(JFrame frame) {
        checkOrderResultView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showMenu() {
        Router.getInstance().showMenu();
    }

    public void cancelOrder() {
        // TODO Auto-generated method stub
    }

    public void modifyOrderRoom() {
        Router.getInstance().showModifyOrderRoomView();
    }

    public void modifyOrderDate() {
        // TODO Auto-generated method stub
    }
}
