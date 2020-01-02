package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderCheckView extends BaseView {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderCheckView window = new OrderCheckView();
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
    public OrderCheckView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Reservation Number:");
        lblNewLabel.setBounds(47, 36, 179, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblHotelId = new JLabel("Hotel ID:");
        lblHotelId.setBounds(86, 73, 73, 25);
        frame.getContentPane().add(lblHotelId);
        
        JLabel label = new JLabel("~");
        label.setBounds(214, 110, 22, 25);
        frame.getContentPane().add(label);
        
        JLabel lblSingle = new JLabel("Single:");
        lblSingle.setBounds(67, 159, 73, 25);
        frame.getContentPane().add(lblSingle);
        
        JLabel lblDouble = new JLabel("Double:");
        lblDouble.setBounds(183, 159, 73, 25);
        frame.getContentPane().add(lblDouble);
        
        JLabel lblQuad = new JLabel("Quad:");
        lblQuad.setBounds(307, 159, 73, 25);
        frame.getContentPane().add(lblQuad);
        
        JLabel lblTotalNightsOf = new JLabel("Total Nights of Stay:");
        lblTotalNightsOf.setBounds(47, 218, 136, 25);
        frame.getContentPane().add(lblTotalNightsOf);
        
        JLabel lblTotalPrize = new JLabel("Total Prize:");
        lblTotalPrize.setBounds(262, 218, 80, 25);
        frame.getContentPane().add(lblTotalPrize);
        
        JButton btnNewButton = new JButton("Cancel Order");
        btnNewButton.setBounds(23, 272, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Modify");
        btnNewButton_1.setBounds(165, 272, 117, 29);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(310, 272, 117, 29);
        frame.getContentPane().add(btnConfirm);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("0");
        textField.setBounds(195, 35, 130, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setText("0");
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(195, 72, 130, 26);
        frame.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setText("0");
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(67, 109, 130, 26);
        frame.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setText("0");
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setColumns(10);
        textField_3.setBounds(250, 109, 130, 26);
        frame.getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setText("0");
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setColumns(10);
        textField_4.setBounds(124, 158, 41, 26);
        frame.getContentPane().add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setText("0");
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setColumns(10);
        textField_5.setBounds(241, 158, 41, 26);
        frame.getContentPane().add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setText("0");
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        textField_6.setColumns(10);
        textField_6.setBounds(358, 158, 41, 26);
        frame.getContentPane().add(textField_6);
        
        textField_7 = new JTextField();
        textField_7.setText("0");
        textField_7.setHorizontalAlignment(SwingConstants.CENTER);
        textField_7.setColumns(10);
        textField_7.setBounds(195, 217, 41, 26);
        frame.getContentPane().add(textField_7);
        
        textField_8 = new JTextField();
        textField_8.setText("0");
        textField_8.setHorizontalAlignment(SwingConstants.CENTER);
        textField_8.setColumns(10);
        textField_8.setBounds(354, 217, 41, 26);
        frame.getContentPane().add(textField_8);
    }
}
