package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.OrderCheckController;

public class OrderCheckView extends BaseView {

    private JFrame frame;
    private JTextField reservationIdField, hotelIdField, startDateField, endDateField;
    private JTextField singleNumField, doubleNumField, quadNumField, stayNightsField, totalPrizeField;
    private OrderCheckController controller;
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
        // initialize();
    }

    public void setProperty(OrderCheckController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel reservationIdLabel = new JLabel("Reservation Number:");
        reservationIdLabel.setBounds(47, 36, 136, 25);
        frame.getContentPane().add(reservationIdLabel);

        JLabel hotelIdLabel = new JLabel("Hotel ID:");
        hotelIdLabel.setBounds(86, 73, 73, 25);
        frame.getContentPane().add(hotelIdLabel);

        JLabel waveLabel = new JLabel("~");
        waveLabel.setBounds(214, 141, 14, 25);
        frame.getContentPane().add(waveLabel);

        JLabel singleLabel = new JLabel("Single:");
        singleLabel.setBounds(67, 190, 52, 25);
        frame.getContentPane().add(singleLabel);

        JLabel doubleLabel = new JLabel("Double:");
        doubleLabel.setBounds(183, 190, 52, 25);
        frame.getContentPane().add(doubleLabel);

        JLabel QuadLabel = new JLabel("Quad:");
        QuadLabel.setBounds(307, 190, 41, 25);
        frame.getContentPane().add(QuadLabel);

        JLabel stayNightsLabel = new JLabel("Total Nights of Stay:");
        stayNightsLabel.setBounds(47, 257, 136, 25);
        frame.getContentPane().add(stayNightsLabel);

        JLabel totalPrizeLabel = new JLabel("Total Prize:");
        totalPrizeLabel.setBounds(262, 257, 80, 25);
        frame.getContentPane().add(totalPrizeLabel);

        JButton cancelButton = new JButton("Cancel Order");
        cancelButton.setBounds(24, 319, 117, 29);
        frame.getContentPane().add(cancelButton);

        JButton modifyButton = new JButton("Modify");
        modifyButton.setBounds(167, 319, 117, 29);
        frame.getContentPane().add(modifyButton);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(310, 319, 117, 29);
        frame.getContentPane().add(confirmButton);

        reservationIdField = new JTextField();
        reservationIdField.setEnabled(false);
        reservationIdField.setHorizontalAlignment(SwingConstants.CENTER);
        reservationIdField.setBounds(195, 35, 130, 26);
        frame.getContentPane().add(reservationIdField);
        reservationIdField.setColumns(10);

        hotelIdField = new JTextField();
        hotelIdField.setEditable(false);
        hotelIdField.setHorizontalAlignment(SwingConstants.CENTER);
        hotelIdField.setColumns(10);
        hotelIdField.setBounds(195, 72, 130, 26);
        frame.getContentPane().add(hotelIdField);

        startDateField = new JTextField();
        startDateField.setEditable(false);
        startDateField.setHorizontalAlignment(SwingConstants.CENTER);
        startDateField.setColumns(10);
        startDateField.setBounds(67, 140, 130, 26);
        frame.getContentPane().add(startDateField);

        endDateField = new JTextField();
        endDateField.setEditable(false);
        endDateField.setHorizontalAlignment(SwingConstants.CENTER);
        endDateField.setColumns(10);
        endDateField.setBounds(250, 140, 130, 26);
        frame.getContentPane().add(endDateField);

        singleNumField = new JTextField();
        singleNumField.setEditable(false);
        singleNumField.setHorizontalAlignment(SwingConstants.CENTER);
        singleNumField.setColumns(10);
        singleNumField.setBounds(124, 189, 41, 26);
        frame.getContentPane().add(singleNumField);

        doubleNumField = new JTextField();
        doubleNumField.setEditable(false);
        doubleNumField.setHorizontalAlignment(SwingConstants.CENTER);
        doubleNumField.setColumns(10);
        doubleNumField.setBounds(241, 189, 41, 26);
        frame.getContentPane().add(doubleNumField);

        quadNumField = new JTextField();
        quadNumField.setEditable(false);
        quadNumField.setHorizontalAlignment(SwingConstants.CENTER);
        quadNumField.setColumns(10);
        quadNumField.setBounds(358, 189, 41, 26);
        frame.getContentPane().add(quadNumField);

        stayNightsField = new JTextField();
        stayNightsField.setEditable(false);
        stayNightsField.setHorizontalAlignment(SwingConstants.CENTER);
        stayNightsField.setColumns(10);
        stayNightsField.setBounds(195, 256, 41, 26);
        frame.getContentPane().add(stayNightsField);

        totalPrizeField = new JTextField();
        totalPrizeField.setEditable(false);
        totalPrizeField.setHorizontalAlignment(SwingConstants.CENTER);
        totalPrizeField.setColumns(10);
        totalPrizeField.setBounds(354, 256, 41, 26);
        frame.getContentPane().add(totalPrizeField);
    }
}
