package controller;

import javax.swing.JFrame;

import view.OrderCheckView;

public class OrderCheckController extends BaseController {
    private OrderCheckView checkOrderView = new OrderCheckView();
    public OrderCheckController(RoutingController router) {
        this.router = router;
    }
    
    @Override
    public void show(JFrame frame) {
//        checkOrderView.setProperty(this, frame);
        frame.setVisible(true);
    }
}
