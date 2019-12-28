package controller;

import javax.swing.JFrame;
import controller.MainController;
import view.SignUpView;

public class SignUpController {
	private MainController mainController;
	private SignUpView signUpView = new SignUpView();
	// private SignUpModel signUpModel = new SignUpModel();
	
	public SignUpController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public void show(JFrame frame) {
		signUpView.setProperty(this, frame);
		frame.setVisible(true);
	}
	
	public void signUp(String username, String password) {
		System.out.println(String.format("[*] SignUp -> Username: %s, Password: %s", username, password));
		if (!username.isEmpty() && !password.isEmpty()) {
			boolean isSuccessSignUp = true; // = signUpModel.signUp(username, password);
			if (isSuccessSignUp) {
				clearFrame(signUpView.frame);
				// this.mainController.showXXXXView();
			} else {
				// signUpView.showErrorMessage("Invalid username or password");
			}
		}
		else {
			// show error
		}
	}
	
	public void clearFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
	}
}



