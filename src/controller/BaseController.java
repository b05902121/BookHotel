package controller;

import javax.swing.JFrame;

public abstract class BaseController {
    protected RoutingController router;
    public abstract void show(JFrame frame);
    protected void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }
}
