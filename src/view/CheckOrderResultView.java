package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CheckOrderResultController;
import main.Order;
import main.UserSession;

public class CheckOrderResultView extends BaseView {
    private JFrame frame;
    private JTextField reservationIdField, hotelIdField, startDateField, endDateField;
    private JTextField singleNumField, doubleNumField, quadNumField, stayNightsField, totalPrizeField;
    private CheckOrderResultController controller;
    private Order checkingOrder;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOrderResultView window = new CheckOrderResultView(true);
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
    private CheckOrderResultView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public CheckOrderResultView() {}

    public void setProperty(CheckOrderResultController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        checkingOrder = UserSession.getInstance(true).getCacheOrder();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        JLabel reservationIdLabel = new JLabel("Reservation Number:");
        reservationIdLabel.setBounds(50, 40, 136, 25);
        frame.getContentPane().add(reservationIdLabel);

        JLabel hotelIdLabel = new JLabel("Hotel ID:");
        hotelIdLabel.setBounds(50, 80, 73, 25);
        frame.getContentPane().add(hotelIdLabel);

        JLabel waveLabel = new JLabel("~");
        waveLabel.setBounds(214, 141, 14, 25);
        frame.getContentPane().add(waveLabel);

        JLabel singleLabel = new JLabel("Single:");
        singleLabel.setBounds(60, 200, 50, 25);
        frame.getContentPane().add(singleLabel);

        JLabel doubleLabel = new JLabel("Double:");
        doubleLabel.setBounds(180, 200, 50, 25);
        frame.getContentPane().add(doubleLabel);

        JLabel QuadLabel = new JLabel("Quad:");
        QuadLabel.setBounds(310, 200, 40, 25);
        frame.getContentPane().add(QuadLabel);

        JLabel stayNightsLabel = new JLabel("Total Nights of Stay:");
        stayNightsLabel.setBounds(50, 260, 140, 25);
        frame.getContentPane().add(stayNightsLabel);

        JLabel totalPrizeLabel = new JLabel("Total Prize:");
        totalPrizeLabel.setBounds(265, 260, 80, 25);
        frame.getContentPane().add(totalPrizeLabel);

        JButton cancelOrderButton = new JButton("Cancel Order");
        cancelOrderButton.setBounds(30, 320, 120, 30);
        frame.getContentPane().add(cancelOrderButton);

        JButton modifyButton = new JButton("Modify");
        modifyButton.setBounds(160, 320, 120, 30);
        frame.getContentPane().add(modifyButton);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(290, 320, 120, 30);
        frame.getContentPane().add(confirmButton);

        reservationIdField = new JTextField();
        reservationIdField.setEditable(false);
        reservationIdField.setHorizontalAlignment(SwingConstants.CENTER);
        reservationIdField.setBounds(200, 40, 130, 25);
        reservationIdField.setColumns(10);
        reservationIdField.setText(checkingOrder.getOrderId().toString());
        frame.getContentPane().add(reservationIdField);

        hotelIdField = new JTextField();
        hotelIdField.setEditable(false);
        hotelIdField.setHorizontalAlignment(SwingConstants.CENTER);
        hotelIdField.setColumns(10);
        hotelIdField.setBounds(200, 80, 130, 25);
        hotelIdField.setText(checkingOrder.getHotelId().toString());
        frame.getContentPane().add(hotelIdField);

        startDateField = new JTextField();
        startDateField.setEditable(false);
        startDateField.setHorizontalAlignment(SwingConstants.CENTER);
        startDateField.setColumns(10);
        startDateField.setBounds(40, 140, 150, 25);
        startDateField.setText(controller.getDateString(checkingOrder.getStartDate()));
        frame.getContentPane().add(startDateField);

        endDateField = new JTextField();
        endDateField.setEditable(false);
        endDateField.setHorizontalAlignment(SwingConstants.CENTER);
        endDateField.setColumns(10);
        endDateField.setBounds(250, 140, 150, 25);
        endDateField.setText(controller.getDateString(checkingOrder.getEndDate()));
        frame.getContentPane().add(endDateField);

        singleNumField = new JTextField();
        singleNumField.setEditable(false);
        singleNumField.setHorizontalAlignment(SwingConstants.CENTER);
        singleNumField.setColumns(10);
        singleNumField.setBounds(120, 200, 40, 25);
        singleNumField.setText(checkingOrder.getsNum().toString());
        frame.getContentPane().add(singleNumField);

        doubleNumField = new JTextField();
        doubleNumField.setEditable(false);
        doubleNumField.setHorizontalAlignment(SwingConstants.CENTER);
        doubleNumField.setColumns(10);
        doubleNumField.setBounds(240, 200, 40, 25);
        doubleNumField.setText(checkingOrder.getdNum().toString());
        frame.getContentPane().add(doubleNumField);

        quadNumField = new JTextField();
        quadNumField.setEditable(false);
        quadNumField.setHorizontalAlignment(SwingConstants.CENTER);
        quadNumField.setColumns(10);
        quadNumField.setBounds(360, 200, 40, 25);
        quadNumField.setText(checkingOrder.getqNum().toString());
        frame.getContentPane().add(quadNumField);

        stayNightsField = new JTextField();
        stayNightsField.setEditable(false);
        stayNightsField.setHorizontalAlignment(SwingConstants.CENTER);
        stayNightsField.setColumns(10);
        stayNightsField.setBounds(200, 260, 50, 25);
        Integer stayNights = checkingOrder.getEndDate() - checkingOrder.getStartDate();
        stayNightsField.setText(stayNights.toString());
        frame.getContentPane().add(stayNightsField);

        totalPrizeField = new JTextField();
        totalPrizeField.setEditable(false);
        totalPrizeField.setHorizontalAlignment(SwingConstants.CENTER);
        totalPrizeField.setColumns(10);
        totalPrizeField.setBounds(360, 260, 50, 25);
        totalPrizeField.setText(checkingOrder.getTotalPrice().toString());
        frame.getContentPane().add(totalPrizeField);

        cancelOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int logoutResult = JOptionPane.showConfirmDialog(frame,
                        "Would you want to cancel order?",
                        "Warning",
                        JOptionPane.OK_CANCEL_OPTION);
                if (logoutResult == JOptionPane.OK_OPTION) {
                    controller.cancelOrder();
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Revise Date", "Change Room", "Cancel"};
                int opt = JOptionPane.showOptionDialog(frame,
                        "Select what you want to change: ",
                        "Change Order",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        "Cancel");
                if (opt==JOptionPane.YES_OPTION) {
                    controller.modifyOrderDate();
                }
                else if (opt==JOptionPane.NO_OPTION) {
                    controller.modifyOrderRoom();
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showMenu();
            }
        });
    }
}
