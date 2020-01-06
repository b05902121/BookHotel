package controller;

import java.text.ParseException;

import javax.swing.JFrame;

import main.Order;
import main.UserSession;
import model.CheckOrderModel;
import model.OrderModel;
import view.CheckOrderResultView;

public class CheckOrderResultController extends BaseController {
    private CheckOrderResultView checkOrderResultView = new CheckOrderResultView();
    private CheckOrderModel checkOrderModel = new CheckOrderModel();
    private Order checkingOrder = UserSession.getInstance(true).getCacheOrder();

    public CheckOrderResultController() {}

    @Override
    public void show(JFrame frame) {
        checkOrderResultView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showMenu() {
        UserSession.getInstance(true).cleanOrderCache();
        Router.getInstance().showMenu();
    }

    public void cancelOrder() {
        checkOrderModel.deleteOrder(checkingOrder.getOrderId(), checkingOrder.getUsername());
        showMenu();
    }

    public void modifyOrderRoom() {
        Router.getInstance().showModifyOrderRoomView();
    }

    public void modifyOrderDate() {
        Router.getInstance().showModifyOrderDateView();
    }

    public String getDateString(Integer date) {
        try {
            return checkOrderModel.intToDateString(date);
        } catch (ParseException e) {
            return "";
        }
    }
}
