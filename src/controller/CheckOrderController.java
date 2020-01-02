package controller;

import javax.swing.JFrame;

import view.CheckOrderView;

public class CheckOrderController extends BaseController {
    private CheckOrderView checkOrderView = new CheckOrderView();

    public CheckOrderController(RoutingController router) {
        this.router = router;
    }

    @Override
    public void show(JFrame frame) {
        checkOrderView.setProperty(this, frame);
        frame.setVisible(true);
    }
    
    public void showCheckOrderResult(int selectedRow) {
        router.showCheckOrderResultView();
    }
}
