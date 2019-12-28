package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.SignUpController;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpView {
	// UI
	public JFrame frame;
	private JTextField usernameTextField;
	private JTextField textField_1;
	
	// Controller
	private SignUpController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView window = new SignUpView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setProperty(SignUpController controller, JFrame frame) {
		this.controller = controller;
		this.frame = frame;
		initialize(frame);
	}

	/**
	 * Create the application.
	 */
	public void init(JFrame frame) {
		this.frame = frame;
		initialize(frame);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
//		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("SIGN UP");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(142, 32, 162, 47);
		frame.getContentPane().add(titleLabel);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(106, 165, 84, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Username");
		label.setBounds(106, 126, 84, 27);
		frame.getContentPane().add(label);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(189, 165, 130, 26);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 126, 130, 26);
		frame.getContentPane().add(textField_1);
		
		JButton submitButton = new JButton("submit");
		submitButton.setBounds(151, 234, 117, 29);
		frame.getContentPane().add(submitButton);
		
		// Set ActionListener
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.signUp(usernameTextField.getText(), textField_1.getText());
			}
		});
	}
}