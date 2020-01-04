package controller;

import javax.swing.JFrame;

import view.ModifyOrderRoomView;

public class ModifyOrderRoomController extends BaseController {
    private ModifyOrderRoomView modifyOrderRoomView = new ModifyOrderRoomView();
    public ModifyOrderRoomController() {}

    @Override
    public void show(JFrame frame) {
        modifyOrderRoomView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }

    public void didTapNextButton() {
        // TODO Auto-generated method stub
    }
}
