package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import controller.MenuController;
import controller.SignInController;

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

		JButton btnNewButton = new JButton("TopLeft");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(70, 70, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("BottomLeft");
		btnNewButton_1.setBounds(70, 160, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("TopRight");
		btnNewButton_2.setBounds(250, 70, 117, 29);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("BottomRight");
		btnNewButton_3.setBounds(250, 160, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
	}
}
