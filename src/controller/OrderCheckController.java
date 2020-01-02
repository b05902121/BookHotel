package controller;

import javax.swing.JFrame;

import view.OrderCheckView;

public class OrderCheckController extends BaseController {
    private OrderCheckView orderCheckView = new OrderCheckView();

    private String hotelName = "hotel1";
    private Integer TotalPrize = 2000;

    public OrderCheckController(RoutingController router) {
        this.router = router;
    }

    @Override
    public void show(JFrame frame) {
        orderCheckView.setProperty(this, frame);
        frame.setVisible(true);
    }
}
