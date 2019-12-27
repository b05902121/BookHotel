package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(189, 165, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 126, 130, 26);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBounds(151, 234, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
