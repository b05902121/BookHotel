package controller;

import javax.swing.JFrame;

import main.UserSession;
import model.OrderModel;
import view.CheckOrderView;

public class CheckOrderController extends BaseController {
    private CheckOrderView checkOrderView = new CheckOrderView();
    private OrderModel orderModel = new OrderModel();
    public CheckOrderController() {}

    @Override
    public void show(JFrame frame) {
        checkOrderView.setProperty(this, frame);
        checkOrderView.setContent(orderModel.findOrderByUsername(UserSession.getInstance(true).getUsername()));
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }

    public void showMenu() {
        Router.getInstance().showMenu();
    }
}
