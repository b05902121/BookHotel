package controller;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.text.ParseException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import main.FrameType;
import main.ImagePanel;
import main.Hotel;
import java.util.ArrayList;

public class Router {
    private static Router instance = new Router();
    private static JFrame mainFrame;
    private Router() {}

    public static Router getInstance() {
        if(instance == null){
            instance = new Router();
        } 
        return instance;
    }

    public void start() {
        setupMainFrame();
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
        drawFrame(new SignInController(), FrameType.Login);
    }

    public void showSignUpView(String username, String password) {
        drawFrame(new SignUpController(username, password), FrameType.SignUp);
    }

    public void showMenu() {
        drawFrame(new MenuController(), FrameType.Menu);
    }

    public void showQueryHotelView() throws ParseException, SQLException {
        drawFrame(new QueryController(), FrameType.Query);
    }

    public void showSearchResultView() {
        drawFrame(new SearchResultController(), FrameType.ShowResult);
    }

    public void showCheckOrderView() {
        drawFrame(new CheckOrderController(), FrameType.CheckOrder);
    }

    public void showCheckOrderResultView() {
        drawFrame(new CheckOrderResultController(), FrameType.CheckOrderResult);
    }

    public void showModifyOrderRoomView() {
        drawFrame(new ModifyOrderRoomController(), FrameType.ModifyOrder);
    }
    public void showConfirmOrder() {
    	drawFrame(new ConfirmOrderController(), FrameType.ConfirmOrder);
    }
    // MARK - Private Method

    private void setupMainFrame() {
        mainFrame = new JFrame("B0ok1ng Hotel");
        mainFrame.setBounds(400, 200, 450, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(null);
    }

    private void drawFrame(BaseController controller, FrameType frameType) {
        clearFrame(mainFrame);
        controller.show(mainFrame);
    }

    private void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }
}
