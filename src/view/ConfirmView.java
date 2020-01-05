package view;

import java.awt.EventQueue;
import main.Order;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
        JLabel lblNewLabel = new JLabel("Confirm Your Order");
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
        JLabel lblNewLabel_1 = new JLabel("Hotel ID : ");
        lblNewLabel_1.setBounds(87, 89, 78, 23);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Reserved Room Number : ");
        lblNewLabel_2.setBounds(87, 124, 170, 29);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Single : ");
        lblNewLabel_3.setBounds(142, 159, 61, 16);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Double : ");
        lblNewLabel_4.setBounds(142, 187, 61, 16);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Quad : ");
        lblNewLabel_5.setBounds(142, 215, 61, 16);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Stay Night : ");
        lblNewLabel_6.setBounds(87, 254, 90, 23);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Order Price : ");
        lblNewLabel_7.setBounds(87, 292, 90, 16);
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

        JButton returnLastPageButton = new JButton("Last page");
        returnLastPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.returnLastPage();
            }
        });
        returnLastPageButton.setBounds(75, 331, 117, 29);
        frame.getContentPane().add(returnLastPageButton);

        JButton doOrderButton = new JButton("Confirm");
        doOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.confirmOrder();
            }
        });
        doOrderButton.setBounds(223, 331, 117, 29);
        frame.getContentPane().add(doOrderButton);
    }

}
