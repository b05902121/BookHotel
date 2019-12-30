package controller;

import javax.swing.JFrame;

public abstract class BaseController {
    public RoutingController router;
    public abstract void show(JFrame frame);
    void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }
}
