package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import main.FrameType;
import main.ImagePanel;

public class RoutingController {
    //	private static RoutingController sharedInstance = new RoutingController();

    private static JFrame mainFrame = new JFrame("B0ok1ng Hotel");

    public void start() {
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("images/hotel_test.jpeg"));
            mainFrame.setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showSignInView();
    }
    
 // MARK - Routing Method

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

    public void showOrderCheckView() {
        drawFrame(new OrderCheckController(this), FrameType.OrderCheck);
    }

    // MARK - Private Method
    
    private void drawFrame(BaseController controller, FrameType frameType) {
        controller.show(mainFrame);
    }
}
