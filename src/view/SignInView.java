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

public class SignInView extends BaseView {
	//	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	private SignInController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInView window = new SignInView();
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
	public void setProperty(SignInController controller, JFrame frame) {
		this.controller = controller;
		this.frame = frame;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel TitleLable = new JLabel("Ｗelcome to B0ok1ng Hotel ! ");
		TitleLable.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLable.setBounds(73, 20, 298, 58);
		frame.getContentPane().add(TitleLable);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(105, 110, 75, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(105, 152, 75, 27);
		frame.getContentPane().add(lblPassword);

		usernameField = new JTextField();
		usernameField.setBounds(206, 115, 151, 15);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new  JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(206, 157, 151, 15);
		frame.getContentPane().add(passwordField);

		JButton registerBtn = new JButton("register");
		registerBtn.setBounds(105, 220, 97, 27);
		frame.getContentPane().add(registerBtn);

		JButton loginBtn = new JButton("login");
		loginBtn.setBounds(227, 219, 117, 29);
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
