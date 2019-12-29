package controller;

import java.sql.SQLException;
import javax.swing.JFrame;
import model.SignInModel;
import view.SignInView;

public class SignInController extends BaseController {
	private MainController mainController;
	private SignInView loginView = new SignInView();
	 SignInModel signInModel = new SignInModel();
	
	public SignInController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public void show(JFrame frame) {
		loginView.setProperty(this, frame);
		frame.setVisible(true);
	}
	
	public void regist(String username, String password) {
		clearFrame(loginView.frame);
		this.mainController.showSignUpView(username, password);
	}
	
	public void login(String username, String password) {
		System.out.println(String.format("[SignIn] Username: %s, Password: %s", username, password));
		try {
			boolean isSuccessLogin = signInModel.signIn(username, password);
			if (isSuccessLogin) {
//				clearFrame(loginView.frame);
//				this.mainController.showXXXXView();
				System.out.println(String.format("[SignIn] isSuccessLogin -> %b", isSuccessLogin));
			} else {
				loginView.showErrorMessage("Invalid username or password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}