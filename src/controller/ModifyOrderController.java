package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.ModifyOrderView;

public class ModifyOrderController extends BaseController {
    private ModifyOrderView modifyOrderView = new ModifyOrderView();
    public ModifyOrderController() {}

    @Override
    public void show(JFrame frame) {
        modifyOrderView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void showCheckOrderResult() {
        Router.getInstance().showCheckOrderResultView();
    }

    public void didTapNextButton() {
        // TODO Auto-generated method stub
    }
}
