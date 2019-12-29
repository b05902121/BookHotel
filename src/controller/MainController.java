package controller;

import javax.swing.*;
import main.FrameType;

public class MainController {
	private static JFrame mainFrame = new JFrame();

	public void start() {
		showSignInView();
	}

	public void showSignInView() {
		drawFrame(new SignInController(this), FrameType.Login);
	}

	public void showSignUpView(String username, String password) {
		drawFrame(new SignUpController(this, username, password), FrameType.SignUp);
	}

	private void drawFrame(BaseController controller, FrameType frameType) {
		controller.show(mainFrame);
	}
}
