package controller;

import javax.swing.JFrame;

import view.SignInView;

public class MenuController extends BaseController {
	private MainController mainController;
	SignInView loginView = new SignInView();
	// LoginModel loginModel = new LoginModel(this);
	
	public MenuController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public void show(JFrame frame) {
//		menuView.setProperty(this, frame);
		frame.setVisible(true);
	}
	
	public void regist(String username, String password) {
		System.out.println(String.format("[*] Regist -> Username: %s, Password: %s", username, password));
		// Call `loginModel.regist(username, password);`
	}
	
	public void login(String username, String password) {
		System.out.println(String.format("[*] Login -> Username: %s, Password: %s", username, password));
		
		boolean isSuccessLogin = true; // = loginModel.login(username, password);
		if (isSuccessLogin) {
			clearFrame(loginView.frame);
//			this.mainController.showSignUpView();
		} else {
			loginView.showErrorMessage("Invalid username or password");
		}
	}
}
