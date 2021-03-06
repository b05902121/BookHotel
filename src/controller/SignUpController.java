package controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import controller.Router;
import model.SignUpModel;
import view.SignUpView;

public class SignUpController extends BaseController {
    private SignUpView signUpView = new SignUpView();
    private SignUpModel signUpModel = new SignUpModel();

    private String enterUsername;
    private String enterPassword;

    public SignUpController(String username, String password) {
        enterUsername = username;
        enterPassword = password;
    }

    @Override
    public void show(JFrame frame) {
        signUpView.setProperty(this, frame);
        if (!enterUsername.isEmpty()) {
            signUpView.setUsername(enterUsername);
        }
        if (!enterPassword.isEmpty()) {
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
                    signUpView.showPopOutMessage("Sign-up succeed!");
                    showSignInView();
                } else {
                    signUpView.showPopOutMessage("Sign-up failed, please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            signUpView.showPopOutMessage("Sign-up failed, please try again.");
        }
    }

    public void showSignInView() {
        Router.getInstance().showSignInView();
    }
}
