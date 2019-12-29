package controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import controller.MainController;
import model.SignUpModel;
import view.SignUpView;

public class SignUpController extends BaseController {
	private MainController mainController;
	private SignUpView signUpView = new SignUpView();
	private SignUpModel signUpModel = new SignUpModel();

	private String enterUsername;
	private String enterPassword;

	public SignUpController(MainController mainController, String username, String password) {
		this.mainController = mainController;
		enterUsername = username;
		enterPassword = password;
	}

	public void show(JFrame frame) {
		signUpView.setProperty(this, frame);
		if (!enterUsername.isBlank()) {
			signUpView.setUsername(enterUsername);
		}
		if (!enterPassword.isBlank()) {
			signUpView.setPassword(enterPassword);
		}
		frame.setVisible(true);
	}

	public void signUp(String username, String password) {
		System.out.println(String.format("[SignUp] Username: %s, Password: %s", username, password));
		if (!username.isEmpty() && !password.isEmpty()) {
			try {
				boolean isSuccessSignUp = signUpModel.signUp(username, password);
				if (isSuccessSignUp) {
					clearFrame(signUpView.frame);
					 this.mainController.showSignInView();
					System.out.println("[SignUp] SignUp Success");
				} else {
					 signUpView.showErrorMessage("Sign-up failed, please try again.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			signUpView.showErrorMessage("Sign-up failed, please try again.");
		}
	}
}
