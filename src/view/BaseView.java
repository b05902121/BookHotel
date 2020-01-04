package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class BaseView {
    public JFrame frame;
    protected abstract void initialize();
    public void showPopOutMessage(String message) {
        JOptionPane.showMessageDialog(this.frame, message);
    }
}