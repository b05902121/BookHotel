package controller;
import view.LoginView;
import javax.swing.*;
import controller.TestSignUpController;
import view.SignUpView;

public class MainController {
	
	public static void main(String[] args) {
		
		// Init other controller
		//  ..
		JFrame frame = new JFrame(); 
		MainController mainController = new MainController();
//		LoginView window = new LoginView();
//		window.init(frame, new TestSignUpController(mainController));
//		frame.setVisible(true);
		mainController.drawFrame(frame, 1, mainController);
	
		
	}
	
	public void drawFrame(JFrame frame, int frameType, MainController mainController) {
		switch (frameType){
			case 1:
				LoginView window = new LoginView();
				window.init(frame, new TestSignUpController(mainController));
				frame.setVisible(true);
				break;
			case 2:
				SignUpView signupView = new SignUpView();
				signupView.init(frame);
				frame.setVisible(true);
				break;
				/*
			case frameType:
				..
				draw another view ...
				break
			EXAMPLE : 
			case 2:
				SignUpView window = new SignUpView();
				window.init(frame, new SignUpViewController(mainController));
				frame.setVisible(true);	
			*/	
			default:
				break;
		}
	}
	
}




