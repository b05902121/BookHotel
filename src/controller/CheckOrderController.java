package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import main.Order;
import main.UserSession;
import model.OrderModel;
import view.CheckOrderView;

public class CheckOrderController extends BaseController {
    private CheckOrderView checkOrderView = new CheckOrderView();
    private OrderModel orderModel = new OrderModel();
    private ArrayList<Order> orderlist;
    public CheckOrderController() {}

    @Override
    public void show(JFrame frame) {
        checkOrderView.setProperty(this, frame);
        orderlist = orderModel.findOrderByUsername(UserSession.getInstance(true).getUsername());
        checkOrderView.setContent(orderlist);
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }

    public void showMenu() {
        Router.getInstance().showMenu();
    }

    public void searchOrderID(String orderId) {
        UserSession.getInstance(true).cleanOrderCache();
        for (Order order: orderlist) {
            if (order.getOrderId().toString().equals(orderId)) {
                UserSession.getInstance(true).setOrderCache(order);
                break;
            }
        }
        if (UserSession.getInstance(true).getCacheOrder() == null) {
            checkOrderView.showPopOutMessage("The entered order ID is wrong, please try again.");
        } else {
            Router.getInstance().showCheckOrderResultView();
        }
    }
}
