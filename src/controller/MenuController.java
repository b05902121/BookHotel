package controller;

import javax.swing.JFrame;

import view.LoginView;

public class MenuController {
	private MainController mainController;
	LoginView loginView = new LoginView();
	// LoginModel loginModel = new LoginModel(this);
	
	public MenuController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public void show(JFrame frame) {
//		loginView.setProperty(this, frame);
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
			this.mainController.showSignUpView();
		} else {
			loginView.showErrorMessage("Invalid username or password");
		}
	}
	
	private void clearFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
	}
}
