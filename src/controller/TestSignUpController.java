package controller;

import javax.swing.JFrame;
import controller.MainController;

public class TestSignUpController {
	
	private MainController mainController;
	public TestSignUpController(MainController mainController) {
		this.mainController = mainController;
	}
	public void recv(int message, JFrame frame) {
		if (message == 0) {
			// do nothing
		}
		else {
			clearFrame(frame);
//			drawFrame(frame);
		}
	}
	
	public void clearFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		mainController.drawFrame(frame, 2, mainController);
	}
	
	
}



