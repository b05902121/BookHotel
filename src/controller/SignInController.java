package controller;

import java.sql.SQLException;
import javax.swing.JFrame;

import model.SignInModel;
import view.SignInView;

public class SignInController extends BaseController {
    private SignInView signInView = new SignInView();
    private SignInModel signInModel = new SignInModel();

    public SignInController() {}

    @Override
    public void show(JFrame frame) {
        signInView.setProperty(this, frame);
        frame.setVisible(true);
    }

    public void regist(String username, String password) {
        Router.getInstance().showSignUpView(username, password);
    }

    public void login(String username, String password) {
        System.out.println(String.format("[SignIn] Username: %s, Password: %s", username, password));
        try {
            boolean isSuccessLogin = signInModel.signIn(username, password);
            if (isSuccessLogin) {
                Router.getInstance().showMenu();
                System.out.println(String.format("[SignIn] isSuccessLogin -> %b", isSuccessLogin));
            } else {
                signInView.showPopOutMessage("Invalid username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
