package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import controller.MenuController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends BaseView {
    //	private JFrame frame;

    private MenuController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuView window = new MenuView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */

    public void setProperty(MenuController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {
        //		frame = new JFrame();
        this.frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton orderHotelButton = new JButton("OrderHotel");
        orderHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        orderHotelButton.setBounds(70, 70, 117, 45);
        frame.getContentPane().add(orderHotelButton);

//        JButton xxxx = new JButton("BottomLeft");
//        xxxx.setBounds(70, 160, 117, 29);
//        frame.getContentPane().add(xxxx);

        JButton checkOrderButton = new JButton("CheckOrder");
        checkOrderButton.setBounds(250, 70, 117, 45);
        frame.getContentPane().add(checkOrderButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(250, 160, 117, 29);
        frame.getContentPane().add(logoutButton);
        
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.logout();
            }
        });
    }
}
