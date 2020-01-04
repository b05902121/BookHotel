package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import controller.SignUpController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class SignUpView extends BaseView {
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;

    private SignUpController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUpView window = new SignUpView(true);
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
    private SignUpView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public SignUpView() {}

    public void setProperty(SignUpController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    public void setUsername(String text) {
        usernameTextField.setText(text);
    }

    public void setPassword(String text) {
        passwordTextField.setText(text);
    }

    /**
     * Initialize the contents of the frame.
     */

    protected void initialize() {
        JLabel titleLabel = new JLabel("SIGN UP");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(142, 32, 162, 47);
        frame.getContentPane().add(titleLabel);

        JLabel lblNewLabel = new JLabel("Password");
        lblNewLabel.setBounds(100, 180, 84, 27);
        frame.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("Username");
        label.setBounds(100, 130, 80, 27);
        frame.getContentPane().add(label);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(200, 130, 130, 25);
        frame.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(200, 180, 130, 25);
        frame.getContentPane().add(passwordTextField);

        JButton submitButton = new JButton("submit");
        submitButton.setBounds(100, 280, 120, 30);
        frame.getContentPane().add(submitButton);

        JButton cancelButton = new JButton("cancel");
        cancelButton.setBounds(230, 280, 120, 30);
        frame.getContentPane().add(cancelButton);

        // Set ActionListener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.signUp(usernameTextField.getText(), String.copyValueOf(passwordTextField.getPassword()));
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showSignInView();
            }
        });
    }
}
