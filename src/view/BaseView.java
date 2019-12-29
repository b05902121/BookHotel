package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class BaseView {
	public JFrame frame;
    public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this.frame, message);
	}
}