package controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import main.FrameType;

class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class RoutingController {
    //	private static RoutingController sharedInstance = new RoutingController();

    private static JFrame mainFrame = new JFrame("Main Frame");

    public void start() {
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("images/hotel_test.jpeg"));
            mainFrame.setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
