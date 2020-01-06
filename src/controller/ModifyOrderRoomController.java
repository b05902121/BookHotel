package controller;

import java.text.ParseException;

import javax.swing.JFrame;

import main.Order;
import main.UserSession;
import model.ModifyOrderModel;
import view.ModifyOrderRoomView;

public class ModifyOrderRoomController extends BaseController {
    private ModifyOrderRoomView modifyOrderRoomView = new ModifyOrderRoomView();
    private ModifyOrderModel modifyOrderModel = new ModifyOrderModel();
    private Order checkingOrder = UserSession.getInstance(true).getCacheOrder();

    public ModifyOrderRoomController() {}

    @Override
    public void show(JFrame frame) {
        modifyOrderRoomView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }

    public void didTapNextButton(Integer sNum, Integer dNum, Integer qNum) {
        try {
            Boolean modifyResult = modifyOrderModel.reviseOrder(checkingOrder.getOrderId(), checkingOrder.getUsername(), checkingOrder.getHotelId(),
                    modifyOrderModel.intToDate(checkingOrder.getStartDate()), modifyOrderModel.intToDate(checkingOrder.getEndDate()),
                    sNum, dNum, qNum, checkingOrder.getTotalPrice());
            System.out.println(String.format("[ModifyOrderRoom] Modify Result -> %b", modifyResult));
            if (modifyResult) {
                modifyOrderRoomView.showPopOutMessage("Modify succeed!");
                UserSession.getInstance(true).cleanOrderCache();
                Router.getInstance().showMenu();
            } else {
                modifyOrderRoomView.showPopOutMessage("Modify failed. Try again.");
            }
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
