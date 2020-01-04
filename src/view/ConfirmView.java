package view;

import java.awt.EventQueue;
import main.Order;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.SearchResultController;
import java.text.SimpleDateFormat;  
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.ConfirmOrderController;
import main.UserSession;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;  
public class ConfirmView {

	private JFrame frame;
	private ConfirmOrderController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmView window = new ConfirmView(true);
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
	private ConfirmView(Boolean flag) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		initialize();
	}
	public ConfirmView() {}
	public void setProperty(ConfirmOrderController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JLabel lblNewLabel = new JLabel("確認您的訂單");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 30, 224, 47);
		frame.getContentPane().add(lblNewLabel);
		Order tmpOrder = UserSession.getInstance(true).getCacheOrder();
		String hotelId = tmpOrder.getHotelId().toString();
		String sNum = tmpOrder.getsNum().toString();
		String dNum = tmpOrder.getdNum().toString();
		String qNum = tmpOrder.getqNum().toString();
		String orderPrice = tmpOrder.getTotalPrice().toString();
		ArrayList<Date> orderDate = UserSession.getInstance(true).getOrderDate();
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String checkInDate = dateFormat.format(orderDate.get(0));
		String checkOutDate = dateFormat.format(orderDate.get(1));
		JLabel lblNewLabel_1 = new JLabel("入住飯店ID : ");
		lblNewLabel_1.setBounds(87, 89, 78, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("預定房型數量 : ");
		lblNewLabel_2.setBounds(87, 124, 90, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("單人房 : ");
		lblNewLabel_3.setBounds(142, 159, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("雙人房 : ");
		lblNewLabel_4.setBounds(142, 187, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("四人房 : ");
		lblNewLabel_5.setBounds(142, 215, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("入住時間 : ");
		lblNewLabel_6.setBounds(87, 254, 73, 23);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("訂單金額 : ");
		lblNewLabel_7.setBounds(87, 292, 73, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel orderPriceValue = new JLabel("New label");
		orderPriceValue.setBounds(172, 292, 200, 16);
		orderPriceValue.setText(orderPrice);
		frame.getContentPane().add(orderPriceValue);
		
		JLabel bookDateValue = new JLabel("New label");
		bookDateValue.setBounds(172, 256, 200, 16);
		bookDateValue.setText(String.format("%s ~ %s", checkInDate, checkOutDate));
		frame.getContentPane().add(bookDateValue);
		
		JLabel quadNumValue = new JLabel("New label");
		quadNumValue.setBounds(199, 215, 200, 16);
		quadNumValue.setText(qNum);
		frame.getContentPane().add(quadNumValue);
		
		JLabel doubleValueNum = new JLabel("New label");
		doubleValueNum.setBounds(199, 187, 200, 16);
		doubleValueNum.setText(dNum);
		frame.getContentPane().add(doubleValueNum);
		
		JLabel singleNumValue = new JLabel("New label");
		singleNumValue.setBounds(199, 159, 200, 16);
		singleNumValue.setText(sNum);
		frame.getContentPane().add(singleNumValue);
		
		JLabel hotelIdValue = new JLabel("New label");
		hotelIdValue.setBounds(186, 92, 200, 16);
		hotelIdValue.setText(hotelId);
		frame.getContentPane().add(hotelIdValue);
		
		JButton returnLastPageButton = new JButton("回上一頁");
		returnLastPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.returnLastPage();
			}
		});
		returnLastPageButton.setBounds(75, 331, 117, 29);
		frame.getContentPane().add(returnLastPageButton);
		
		JButton doOrderButton = new JButton("確定預定");
		doOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		doOrderButton.setBounds(223, 331, 117, 29);
		frame.getContentPane().add(doOrderButton);
	}

}
