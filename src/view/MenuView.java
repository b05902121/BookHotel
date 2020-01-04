package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import controller.MenuController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
public class MenuView extends BaseView {
    private JFrame frame;
    private MenuController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuView window = new MenuView(true);
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
    private MenuView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public MenuView() {}

    public void setProperty(MenuController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        JButton orderHotelButton = new JButton("OrderHotel");
        orderHotelButton.setBounds(70, 70, 117, 45);
        frame.getContentPane().add(orderHotelButton);

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

        orderHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showQueryHotelView();
            }
        });

        checkOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showcheckOrderView();
            }
        });
    }
}
