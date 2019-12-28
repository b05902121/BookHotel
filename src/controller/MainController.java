package controller;

import javax.swing.*;
import main.FrameType;

public class MainController {
	private static JFrame mainFrame = new JFrame(); 
	
	public void start() {
		showLoginView();
	}
	
	public void showLoginView() {
		drawFrame(FrameType.Login);
	}
	
	public void showSignUpView() {
		drawFrame(FrameType.SignUp);
	}

	public void drawFrame(FrameType frameType) {
		switch (frameType) {
			case Login:
				LoginController loginController = new LoginController(this);
				loginController.show(mainFrame);
				break;
			case SignUp:
				SignUpController testSignUpController = new SignUpController(this);
				testSignUpController.show(mainFrame);
				break;
			case Menu:
				break;
				/*
			case frameType:
				..
				draw another view ...
				break
			EXAMPLE : 
			case SignUp:
				SignUpView window = new SignUpView();
				window.init(frame, new SignUpViewController(mainController));
				frame.setVisible(true);	
			*/
		}
	}
}




