package controller;

import javax.swing.*;
import main.FrameType;

public class RoutingController {
    //	private static RoutingController sharedInstance = new RoutingController();
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

    public void showMenu() {
        drawFrame(new MenuController(this), FrameType.Menu);
    }
    public void showQueryHotelView() {
    	drawFrame(new QueryController(this), FrameType.Query);
    }
    public void showSearchResultView() {
    	drawFrame(new SearchResultController(this), FrameType.ShowResult);
    }
    private void drawFrame(BaseController controller, FrameType frameType) {
        controller.show(mainFrame);
    }
}
