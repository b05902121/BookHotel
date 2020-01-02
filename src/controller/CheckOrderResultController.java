package controller;

import javax.swing.JFrame;

import view.CheckOrderResultView;

public class CheckOrderResultController extends BaseController {
    private CheckOrderResultView checkOrderResultView = new CheckOrderResultView();

    private String hotelName = "hotel1";
    private Integer TotalPrize = 2000;

    public CheckOrderResultController(RoutingController router) {
        this.router = router;
    }

    @Override
    public void show(JFrame frame) {
        checkOrderResultView.setProperty(this, frame);
        frame.setVisible(true);
    }
}
