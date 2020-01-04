package controller;

import java.util.Date;
import java.text.ParseException;

import javax.swing.JFrame;

import main.Order;
import main.UserSession;
import model.OrderModel;
import view.ModifyOrderDateView;

public class ModifyOrderDateController extends BaseController {
    private ModifyOrderDateView modifyOrderDateView = new ModifyOrderDateView();
    private OrderModel orderModel = new OrderModel();
    private Order checkingOrder = UserSession.getInstance(true).getCacheOrder();

    public ModifyOrderDateController() {}

    @Override
    public void show(JFrame frame) {
        modifyOrderDateView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }
    
    public String getDateString(Integer date) {
        try {
            return orderModel.intToDateString(date);
        } catch (ParseException e) {
            return "";
        }
    }

    public void didTapNextButton(Date startDate, Date endDate) {
        try {
            Boolean modifyResult = orderModel.reviseOrder(checkingOrder.getOrderId(), checkingOrder.getUsername(), checkingOrder.getHotelId(),
                    startDate, endDate, checkingOrder.getsNum(), checkingOrder.getdNum(),
                    checkingOrder.getqNum(), checkingOrder.getTotalPrice());
            System.out.println(String.format("[ModifyOrderRoom] Modify Result -> %b", modifyResult));
            if (modifyResult) {
                modifyOrderDateView.showPopOutMessage("Modify succeed!");
                UserSession.getInstance(true).cleanOrderCache();
                Router.getInstance().showMenu();
            } else {
                modifyOrderDateView.showPopOutMessage("Modify failed. Try again.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
