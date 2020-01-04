package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.SignInController;
import java.awt.Font;

public class SignInView extends BaseView {
    private JFrame frame;
    private SignInController controller;

    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignInView window = new SignInView(true);
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
    private SignInView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public SignInView() {}

    public void setProperty(SignInController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        JLabel TitleLable = new JLabel("Ｗelcome to B0ok1ng Hotel ! ");
        TitleLable.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        TitleLable.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLable.setBounds(75, 50, 300, 60);
        frame.getContentPane().add(TitleLable);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(105, 150, 75, 27);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(105, 210, 75, 27);
        frame.getContentPane().add(lblPassword);

        usernameField = new JTextField();
        usernameField.setBounds(206, 150, 151, 25);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new  JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(206, 210, 151, 25);
        frame.getContentPane().add(passwordField);

        JButton registerBtn = new JButton("register");
        registerBtn.setBounds(100, 300, 120, 30);
        frame.getContentPane().add(registerBtn);

        JButton loginBtn = new JButton("login");
        loginBtn.setBounds(230, 300, 120, 30);
        frame.getContentPane().add(loginBtn);

        // Set ActionListener
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.regist(usernameField.getText(), String.copyValueOf(passwordField.getPassword()));
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.login(usernameField.getText(), String.copyValueOf( passwordField.getPassword()));
            }
        });
    }
}
