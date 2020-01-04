package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import controller.MenuController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Font;

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
        JButton orderHotelButton = new JButton("Order Hotel");
        orderHotelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        orderHotelButton.setBounds(60, 150, 140, 90);
        frame.getContentPane().add(orderHotelButton);

        JButton checkOrderButton = new JButton("Check Order");
        checkOrderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        checkOrderButton.setBounds(250, 150, 140, 90);
        frame.getContentPane().add(checkOrderButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(300, 330, 120, 30);
        frame.getContentPane().add(logoutButton);


        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(frame,
                        "Would you want to log out?",
                        "Warning",
                        JOptionPane.OK_CANCEL_OPTION);
                if(dialogResult == JOptionPane.OK_OPTION) {
                    controller.logout();
                }
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
